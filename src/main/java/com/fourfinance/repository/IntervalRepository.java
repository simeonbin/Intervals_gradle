package com.fourfinance.repository;

import com.fourfinance.service.Interval;

import java.util.ArrayList;
import java.util.List;

public interface IntervalRepository {

    /**
     * Retrieves all intervals
     *
     * @return a list of intervals
     */
    List<Interval> findAll(ArrayList<Interval> intervals);

}
