package com.optional;


public class TimeKeeper extends Thread {
    private static int nrMin;
    private static int nrSec;
    private static int limitTime;//minutes
    private static boolean isFinished;

    public TimeKeeper() {
        nrMin = 0;
        nrSec = 0;
        limitTime = 0;
        isFinished = false;
    }

    public TimeKeeper(int boundd) {
        nrMin = 0;
        nrSec = 0;
        limitTime = boundd;
        isFinished = false;
    }

    public static boolean isFinished(){
        return nrMin >= limitTime;
    }


    public void increment() {
        nrSec++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (nrSec == 30) {
            nrMin++;
            nrSec = 0;
        }
    }


    @Override
    public void run() {

        int counter = 0;
        System.out.println('\n' + this.toString());
        while (nrMin < 1) {
            increment();
            counter++;
            if (counter == 3) {
                System.out.println('\n' + this.toString());
                counter = 0;
            }

        }
        isFinished = true;
    }

    @Override
    public String toString() {
        return nrMin + " : " + nrSec;
    }
}
