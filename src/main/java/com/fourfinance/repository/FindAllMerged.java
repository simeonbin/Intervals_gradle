package com.fourfinance.repository;

import com.fourfinance.service.Interval;
import com.fourfinance.service.IntervalComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Simeon on 7/13/2017.
 */

public class FindAllMerged implements IntervalRepository {

    public List<Interval> findAll(ArrayList<Interval> intervals) {

        if (intervals.isEmpty() || intervals.size() == 1)
            return intervals;

        Collections.sort(intervals, new IntervalComparator());

        Interval first = intervals.get(0);
        int start = first.getStart();
        int end = first.getEnd();

        ArrayList<Interval> result = new ArrayList<>();

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);

            // if Interval[i].start <= Interval[i-1].end, overlapping interval
            if (current.getStart() <= end)
            {
                // Got Overlapping!!
                // end = max(Interval[i].end, Interval[i-1].end),
                // 'end' gets the bigger value of the two,
                //  then keep moving the LOOP. 'start' NOT changing yet!!

                end = Math.max(current.getEnd(), end);

            } else      // Non-overlapping interval, insert previous (start,end) to result List
              {
                result.add(new Interval(start, end));

                // non-overlapping interval, 'start' now is about to become larger than previous 'end'
                // brand new (start,end) exists in current interval.

                start = current.getStart();
                end = current.getEnd();
              }
        }

        result.add(new Interval(start, end));
        return result;
    }
}