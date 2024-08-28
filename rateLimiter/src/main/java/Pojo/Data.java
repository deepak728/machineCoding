package Pojo;

import java.time.Instant;
import java.util.TimeZone;


public class Data {


    int counter;
    int maxCounter;

    int windowInSec;
     Instant lastTime;

    public Data(int counter, int maxCounter,int window,Instant time){
        this.counter = counter;
        this.maxCounter = maxCounter;
        this.windowInSec = window;
        this.lastTime= time;
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
}
