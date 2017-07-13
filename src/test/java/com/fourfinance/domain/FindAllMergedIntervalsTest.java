package com.fourfinance.domain;

import com.fourfinance.repository.FindAllMerged;
import com.fourfinance.service.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Simeon on 7/13/2017.
 */

public class FindAllMergedIntervalsTest {


    @Test
    public void findAllMergedInts() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);
        Interval interval5 = new Interval(17, 20);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest2 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest2)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest2.get(0).getEnd(), 6);
        assertEquals(intervalListTest2.get(1).getEnd(), 10);
        assertEquals(intervalListTest2.get(2).getEnd(), 20);

    }

    @Test
    public void findAllMergedInts_Disjointed() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(1, 3);
        Interval interval2 = new Interval(6, 16);
        Interval interval3 = new Interval(17, 26);
        Interval interval4 = new Interval(29, 38);
        Interval interval5 = new Interval(39, 40);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest3 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest3)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest3.get(0).getEnd(), 3);
        assertEquals(intervalListTest3.get(1).getEnd(), 16);
        assertEquals(intervalListTest3.get(2).getEnd(), 26);
        assertEquals(intervalListTest3.get(3).getEnd(), 38);
        assertEquals(intervalListTest3.get(4).getEnd(), 40);

    }

    @Test
    public void findAllMergedInts_AllIncluded() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(1, 100);
        Interval interval2 = new Interval(6, 16);
        Interval interval3 = new Interval(17, 26);
        Interval interval4 = new Interval(29, 38);
        Interval interval5 = new Interval(39, 40);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 100);


    }

    @Test
    public void findAllMergedInts_StartWithinIntervalEndLarger() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(1, 100);
        Interval interval2 = new Interval(6, 107);
        Interval interval3 = new Interval(17, 117);
        Interval interval4 = new Interval(29, 118);
        Interval interval5 = new Interval(39, 128);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 128);
        assertEquals(intervalListTest4.get(0).getStart(), 1);

    }

    @Test
    public void findAllMergedInts_StartAlwaysSmallerEndSmaller() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(50, 100);
        Interval interval2 = new Interval(40, 50);
        Interval interval3 = new Interval(30, 40);
        Interval interval4 = new Interval(20, 30);
        Interval interval5 = new Interval(10, 20);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 100);
        assertEquals(intervalListTest4.get(0).getStart(), 10);

    }
    @Test
    public void findAllMergedInts_StartAlwaysSmallerEndWithinInterval() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(50, 100);
        Interval interval2 = new Interval(40, 60);
        Interval interval3 = new Interval(30, 70);
        Interval interval4 = new Interval(20, 80);
        Interval interval5 = new Interval(10, 90);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 100);
        assertEquals(intervalListTest4.get(0).getStart(), 10);
    }

    @Test
    public void findAllMergedInts_StartAlwaysSmallerEndAlwaysLarger() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(50, 100);
        Interval interval2 = new Interval(40, 110);
        Interval interval3 = new Interval(30, 120);
        Interval interval4 = new Interval(20, 130);
        Interval interval5 = new Interval(10, 140);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 140);
        assertEquals(intervalListTest4.get(0).getStart(), 10);
    }

    @Test
    public void findAllMergedInts_StartWithinIntervalEndAlwaysLarger2() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(0, 10);
        Interval interval2 = new Interval(7, 12);
        Interval interval3 = new Interval(8, 13);
        Interval interval4 = new Interval(9, 14);
        Interval interval5 = new Interval(10, 15);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 15);
        assertEquals(intervalListTest4.get(0).getStart(), 0);
    }

    @Test
    public void findAllMergedInts_StartNegativePositiveEndNegativePositive() throws Exception {

        List<Interval> intervalListTest = new ArrayList<>(10);

        FindAllMerged find = new FindAllMerged();

        Interval interval = new Interval(-100, 10);
        Interval interval2 = new Interval(-70, 120);
        Interval interval3 = new Interval(-80, 13);
        Interval interval4 = new Interval(-90, 140);
        Interval interval5 = new Interval(-10, 150);

        intervalListTest.add(interval);
        intervalListTest.add(interval2);
        intervalListTest.add(interval3);
        intervalListTest.add(interval4);
        intervalListTest.add(interval5);

        List<Interval> intervalListTest4 = find.findAll((ArrayList <Interval> ) intervalListTest);

        for(Interval i : intervalListTest4)
        {
            System.out.println(i.getStart() + " " + i.getEnd());
        }

        assertEquals(intervalListTest4.get(0).getEnd(), 150);
        assertEquals(intervalListTest4.get(0).getStart(), -100);
    }

}