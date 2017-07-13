package com.fourfinance.service;

import java.util.Comparator;

/**
 * Created by Simeon on 7/13/2017.
 */
public class IntervalComparator implements Comparator<Interval>
{
   // @Override
    public int compare(Interval i1, Interval i2)
    {
        return i1.getStart() - i2.getStart();
    }
}
