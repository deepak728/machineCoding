package service;

import Pojo.UserRequest;

public class LeakyBucket implements RateLimiter{
    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        return false;
    }
}
