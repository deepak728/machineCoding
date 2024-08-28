package service;

import Pojo.UserRequest;

public class SlidingWindowLog implements RateLimiter{
    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        return false;
    }
}
