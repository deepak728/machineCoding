package service;

import Pojo.UserRequest;

import java.util.HashMap;
import java.util.Map;

public class APIGateway {

    private static Map<String, RateLimiter> objectMap = new HashMap<>();

    public void init(){
        objectMap.put("tokenBucket", TokenBucket.getInstance());
    }
    public void makeRequest(UserRequest userRequest){
        if(!objectMap.containsKey(userRequest.getRateLimiter())) return;
        RateLimiter rateLimiter = objectMap.get(userRequest.getRateLimiter());

        rateLimiter.checkRateLimit(userRequest);
        //System.out.println();
    }
}
