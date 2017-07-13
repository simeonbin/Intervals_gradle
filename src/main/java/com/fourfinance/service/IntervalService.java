package com.fourfinance.service;

import com.fourfinance.service.Interval;

import java.util.ArrayList;
import java.util.List;

public interface IntervalService {

    /**
     * Merges overlapping intervals, the intervals are retrieved using {@link IntervalRepository}
     *
     * @return a list of merged intervals
     */
    List<Interval> findAllMerged(ArrayList<Interval> intervals);

}
