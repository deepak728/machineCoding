package Pojo;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.TimeZone;


public class Data {


    int counter;
    int maxCounter;

    int windowInSec;
     Instant lastTime;

     Deque<UserRequest> queue;

    public Data(int counter, int maxCounter,int window,Instant time, Deque<UserRequest> queue){
        this.counter = counter;
        this.maxCounter = maxCounter;
        this.windowInSec = window;
        this.lastTime= time;
        this.queue = queue;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getMaxCounter() {
        return maxCounter;
    }

    public void setMaxCounter(int maxCounter) {
        this.maxCounter = maxCounter;
    }

    public int getWindowInSec() {
        return windowInSec;
    }

    public void setWindowInSec(int windowInSec) {
        this.windowInSec = windowInSec;
    }

    public Instant getLastTime() {
        return lastTime;
    }

    public void setLastTime(Instant lastTime) {
        this.lastTime = lastTime;
    }

    public Deque<UserRequest> getQueue() {
        return queue;
    }

    public void setQueue(Deque<UserRequest> queue) {
        this.queue = queue;
    }
}
