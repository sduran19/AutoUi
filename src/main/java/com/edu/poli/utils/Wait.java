package com.edu.poli.utils;

public class Wait {

    Wait() {
    }

    public static void inSeconds(double intSeconds) {
        try {
            Thread.sleep((long) (intSeconds*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}