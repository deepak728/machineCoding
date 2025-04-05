package service;

import Pojo.Data;
import Pojo.UserRequest;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SlidingWindowCounter implements RateLimiter{

    private static final SlidingWindowCounter instance = new SlidingWindowCounter();

    private static ConcurrentMap<String, Data> userDataMap = new ConcurrentHashMap<>();

    private SlidingWindowCounter(){}

    public static SlidingWindowCounter getInstance(){
        return instance;
    }

    private Data getUserData(UserRequest userRequest, Instant currTime){
        if(!userDataMap.containsKey(userRequest.getUser())){
            userDataMap.put(userRequest.getUser(),
                    new Data(0,userRequest.getMaxAllowedReq(),10,currTime,null,0));
        }

        return userDataMap.get(userRequest.getUser());
    }

    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        Data data = getUserData(userRequest,Instant.now());

        if(calculateReq(Instant.now(),userRequest) < userRequest.getMaxAllowedReq()){
            System.out.println("Request "+userRequest.getUuid()+" is allowed for user "+userRequest.getUser());
            return true;
        }else{
            System.out.println("Request "+userRequest.getUuid()+" is rate limited for user "+userRequest.getUser());
            return false;
        }
    }

    private int calculateReq(Instant time, UserRequest userRequest){
        return 0;
    }
}
