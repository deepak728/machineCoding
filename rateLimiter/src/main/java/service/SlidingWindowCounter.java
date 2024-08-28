package service;

import Pojo.UserRequest;

public class SlidingWindowCounter implements RateLimiter{
    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        return false;
    }
}
