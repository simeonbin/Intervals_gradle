package com.fourfinance.service;

/**
 * Created by Simeon on 7/13/2017.
 */
public class Interval
{
    private int start;
    private int end;

    Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {

    //    if ((s >= 0) && (e >= 0) && (s <= e)) {
        if ((s <= e)) {
            start = s; end = e;
        }
       else {
        //   System.out.printf("Interval Start and End BOTH have to be positive Integers and Start Smaller Or Equal than End %d %d%n", s, e);
            System.out.printf("Interval Start has to be Smaller Or Equal than Interval End %d %d%n", s, e);
           System.exit(2);
       }
    }


    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

