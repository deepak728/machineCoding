package service;

import Pojo.UserRequest;

public class FixedWindow implements RateLimiter{

    @Override
    public boolean checkRateLimit(UserRequest userRequest) {
        return false;
    }
}
