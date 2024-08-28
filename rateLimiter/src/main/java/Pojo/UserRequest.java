package Pojo;

public class UserRequest {
    String user;
    String rateLimiter;

    int uuid;

    int maxAllowedReq;

    public UserRequest(String user, String rateLimiter,int uuid,int maxAllowedReq) {
        this.user = user;
        this.rateLimiter = rateLimiter;
        this.uuid = uuid;
        this.maxAllowedReq = maxAllowedReq;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRateLimiter() {
        return rateLimiter;
    }

    public void setRateLimiter(String rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getMaxAllowedReq() {
        return maxAllowedReq;
    }

    public void setMaxAllowedReq(int maxAllowedReq) {
        this.maxAllowedReq = maxAllowedReq;
    }
}
