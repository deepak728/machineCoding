package org.example;

import Pojo.UserRequest;
import service.APIGateway;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        APIGateway apiGateway = new APIGateway();
        apiGateway.init();

        for(int i=0;i<10;i++){
            apiGateway.makeRequest(new UserRequest("deepak","tokenBucket",i,3));
            if(i%5==0){
                sleep(5);
            }
        }
        System.out.println();
        System.out.println();

        for(int i=0;i<10;i++){
            apiGateway.makeRequest(new UserRequest("devesh","tokenBucket",i,2));
            if(i%5==0){
                sleep(5);
            }
        }

        System.out.println();
        System.out.println("LeakyBucket");

        for(int i=0;i<10;i++){
            apiGateway.makeRequest(new UserRequest("devesh","leakyBucket",i,3));
            if(i%5==0){
                sleep(5);
            }
        }

        System.out.println();
        System.out.println("FixedWindow");

        for(int i=1;i<=10;i++){
            apiGateway.makeRequest(new UserRequest("devesh","fixedWindow",i,3));
            if(i%5==0){
                sleep(5);
            }
        }


    }

    public static void sleep(int sec){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}