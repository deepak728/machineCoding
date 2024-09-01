package service;

import Pojo.Data;
import Pojo.UserRequest;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class FixedWindow implements RateLimiter{

    private static FixedWindow instance = new FixedWindow();

    private static ConcurrentMap<String, Data> userDataMap = new ConcurrentHashMap<>();

    private final static int currWinInSec = 5;


    private FixedWindow() {
        startSchedulerService();
    }

    public static FixedWindow getInstance(){
        return instance;
    }

    private Data getUserData(UserRequest userRequest, Instant currentTime){
        String user = userRequest.getUser();
        if(!userDataMap.containsKey(user)){
            userDataMap.put(user,new Data(0,3, currWinInSec, Instant.now(),null));
        }
        return userDataMap.get(user);
    }

    private void changeCounter(String user, int add){
        userDataMap.computeIfPresent(user, (key,data) -> {
            data.setCounter(data.getCounter()+add);
            return data;
        });
    }

    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        if(userRequest ==null || userRequest.getUser()==null) return false;

        Data data = getUserData(userRequest,Instant.now());

        if(data.getCounter() <data.getMaxCounter()){
            System.out.println("Allowed request "+ userRequest.getUuid() +"for user "+ userRequest.getUser());
            changeCounter(userRequest.getUser(),1);
            return true;
        }else{
            System.out.println("Rate limited request "+ userRequest.getUuid() +"for user "+ userRequest.getUser());
            return false;
        }
    }

    private void resetCounter(){

        userDataMap.forEach((user,data) -> {
            data.setCounter(0);
            System.out.println("Reset the counter for user "+ user);
        });

    }

    private void startSchedulerService(){
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(this::resetCounter, 0,currWinInSec, TimeUnit.SECONDS);
    }
}
