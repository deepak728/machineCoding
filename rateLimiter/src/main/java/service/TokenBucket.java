package service;

import Pojo.Data;
import Pojo.UserRequest;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

public class TokenBucket implements RateLimiter{

    private static final TokenBucket instance = new TokenBucket();

    private TokenBucket(){}

    public static TokenBucket getInstance(){
        return instance;
    }
    //private static int maxToken = 3;

    private static Map<String, Data> userDataMap = new HashMap<>();

    private Data getUserRateLimitData(UserRequest userRequest, Instant currentTime){
        if(userRequest==null || userRequest.getUser() == null) return null;
        String user = userRequest.getUser();

        if(!userDataMap.containsKey(user)){
            userDataMap.put(user,new Data(userRequest.getMaxAllowedReq(), userRequest.getMaxAllowedReq(), 5,Instant.now()));
        }

        Data userData = userDataMap.get(user);
        Instant lastFilledTIme = userData.getLastTime();
        if(Duration.between(lastFilledTIme,currentTime).getSeconds() >= userData.getWindowInSec()){
            System.out.println("Refilling token -----");
            changeCounter(user,true, currentTime);
        }
        return userData;
    }

    private void changeCounter(String user, boolean isReset, Instant time){
        if(user != null && !userDataMap.containsKey(user)) return;

        Data userData = userDataMap.get(user);
        if(isReset){
            userData.setCounter(userData.getMaxCounter());
            userData.setLastTime(time);
        }else{
            userData.setCounter(userData.getCounter()-1);
        }
        userDataMap.put(user,userData);

    }

    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        Data userData = getUserRateLimitData(userRequest,Instant.now());
        //System.out.println("userData: "+ userData.getCounter()+ " "+ userData.getLastTime() + " "+ Instant.now());

        if(userData.getCounter()>0){
            System.out.println("Request "+userRequest.getUuid()+ " is allowed for user " + userRequest.getUser());
            changeCounter(userRequest.getUser(),false,Instant.now());
            return true;
        }else{
            System.out.println("Request "+userRequest.getUuid()+ " is rate limited user " + userRequest.getUser());
            return false;
        }
    }


}
