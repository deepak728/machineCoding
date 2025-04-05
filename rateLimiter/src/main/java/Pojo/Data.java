package Pojo;

import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.TimeZone;


public class Data<T> {

    int counter;
    int maxCounter;

    int windowInSec;
    Instant lastTime;
    int lastCounter;

     Deque<T> queue;

    public Data(int counter, int maxCounter,int window,Instant time, Deque<T> queue){
        this.counter = counter;
        this.maxCounter = maxCounter;
        this.windowInSec = window;
        this.lastTime= time;
        this.queue = queue;
    }

    public Data(int counter, int maxCounter,int window,Instant time, Deque<T> queue, int lastCounter){
        this.counter = counter;
        this.maxCounter = maxCounter;
        this.windowInSec = window;
        this.lastTime= time;
        this.queue = queue;
        this.lastCounter= lastCounter;
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

    public Deque<T> getQueue() {
        return queue;
    }

    public void setQueue(Deque<T> queue) {
        this.queue = queue;
    }

    public int getLastCounter() {
        return lastCounter;
    }

    public void setLastCounter(int lastCounter) {
        this.lastCounter = lastCounter;
    }
}
