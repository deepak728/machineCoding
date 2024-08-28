package service;

import Pojo.UserRequest;

public interface RateLimiter {
    public boolean checkRateLimit(UserRequest userRequest);
}
