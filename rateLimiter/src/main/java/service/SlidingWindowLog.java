package service;

import Pojo.Data;
import Pojo.UserRequest;

import java.time.Duration;
import java.time.Instant;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;

public class SlidingWindowLog implements RateLimiter{

    private static final SlidingWindowLog instance = new SlidingWindowLog();

    private SlidingWindowLog(){}

    public static SlidingWindowLog getInstance(){
        return instance;
    }

    public static ConcurrentMap<String, Data> userDataMap = new ConcurrentHashMap<>();

    private Data getUserData(UserRequest userRequest, Instant currTime){
        String user = userRequest.getUser();
        if(!userDataMap.containsKey(user)){
            userDataMap.put(user,new Data(0, userRequest.getMaxAllowedReq(),
                    5,Instant.now(),new ConcurrentLinkedDeque<>()));
        }

        removeStaleRequests(userDataMap.get(user), currTime,user);
        return userDataMap.get(user);
    }

    private void removeStaleRequests(Data data, Instant currTime,String user){
        Deque<UserRequest> requestQueue = data.getQueue();
        while(!requestQueue.isEmpty()){

            UserRequest request = requestQueue.peek();
            if(Duration.between(request.getCurrTime(), currTime).getSeconds() >= data.getWindowInSec()){
                System.out.println("Removing expired request "+request.getUuid());
                requestQueue.poll();
            } else{
                data.setQueue(requestQueue);
                userDataMap.put(user,data);
                return;
            }
        }
    }
    @Override
    public boolean checkRateLimit(UserRequest userRequest) {

        Data data = getUserData(userRequest, Instant.now());
        if(data.getQueue().size()<userRequest.getMaxAllowedReq()){
            System.out.println("Request "+userRequest.getUuid()+" allowed for user "+userRequest.getUser());
            addRequestToQueue(userRequest);
            return true;
        }else{
            System.out.println("Rate limited Request "+userRequest.getUuid()+" for user "+userRequest.getUser());
            return false;
        }
    }

    void addRequestToQueue(UserRequest userRequest){
        Data data = userDataMap.get(userRequest.getUser());
        data.getQueue().add(userRequest);
        userDataMap.put(userRequest.getUser(), data);
    }
}
