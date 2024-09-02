package service;

import Pojo.Data;
import Pojo.UserRequest;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LeakyBucket implements RateLimiter{

    private static final LeakyBucket instance = new LeakyBucket();

    private LeakyBucket(){
        startScheduledService();
    }
    public static LeakyBucket getInstance(){
        return instance;
    }

    private static Map<String, Data> userDataMap = new HashMap<>();

    private Data pullData(UserRequest userRequest, Instant time){
        if(!userDataMap.containsKey(userRequest.getUser())){
            userDataMap.put(userRequest.getUser(),
                    new Data(0,userRequest.getMaxAllowedReq(), 7, Instant.now(), new ArrayDeque<UserRequest>()));
        }

        return userDataMap.get(userRequest.getUser());
    }

    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        String user = userRequest.getUser();
        Data data = pullData(userRequest, Instant.now());

        if(data.getQueue().size() >= userRequest.getMaxAllowedReq()){
            System.out.println("Request "+userRequest.getUuid()+" is rate limited for user "+user);
            return false;
        }else{
            System.out.println("Request "+userRequest.getUuid()+" is allowed for user "+user);
            data.getQueue().add(userRequest);
            return false;
        }
    }

    private void makeRequest(){
        userDataMap.forEach((key,value) -> {
            if(value.getQueue().size()>0){
                System.out.println("making request for user "+key+ " request "+value.getQueue().poll());
            }
        });
    }

    private void startScheduledService(){
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleAtFixedRate(this::makeRequest,0,7/3, TimeUnit.SECONDS);
    }
}
