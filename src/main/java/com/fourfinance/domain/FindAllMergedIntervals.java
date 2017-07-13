package com.fourfinance.domain;

import com.fourfinance.repository.FindAllMerged;
import com.fourfinance.service.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simeon on 7/13/2017.
 */
public class FindAllMergedIntervals  {

    public static void main (String[] args) throws java.lang.Exception
    {

        FindAllMerged find = new FindAllMerged();
        List<Interval> intervalList = new ArrayList<>();

        intervalList.add(new Interval(0, 10));
        intervalList.add(new Interval(7, 12));
        intervalList.add(new Interval(8, 13));
        intervalList.add(new Interval(9, 14));
        intervalList.add(new Interval(10, 15));

        intervalList = find.findAll((ArrayList <Interval> ) intervalList);

        for(Interval i : intervalList)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }
    }
}
