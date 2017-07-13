This is a Java developer coding task assignment.

The goal is to implement IntervalService and corresponding unit tests to test the functionality.

The IntervalService is supposed to merge overlapping intervals together and return a list of distict intervals.
In details
 - retrieves intervals from IntervalRepository using findAll()
 - merge (inclusive) overlapping intervals together
 - returns a list of distinct intervals

You can use JUnit, Mockito and Spock for implementing the unit tests.

The task evaluation criteria are the following
 - correct implementation of the task
 - code quality and readability
 - test coverage
 - computational complexity of the implementation
 - time to finish the task

You should finish the task in about an hour.


=================================================================================

					SIMEON BINIATIDIS
					JULY 13, 2017
					
					
	The program produces a set (List-ArrayList) of merged distinct integer intervals for a given 
	set (List-ArrayList) of (possibly randomly) overlapping integer intervals.
	
	A simple approach is to start from the first interval and compare it with all other intervals 
	for overlapping, if it overlaps with any other interval, then remove the other interval from list 
	and merge the other into the first interval. Repeat same steps for remaining intervals after first. 
	This approach cannot be implemented in better than O(n^2) time.
	
	A more efficient approach is to first Sort intervals according to Start_time ('IntervalComparator')
	Once intervals are sorted, combine them in linear traversal. 
	So, in sorted array of intervals, if interval[i] doesn’t overlap with interval[i-1], 
	then interval[i+1] cannot overlap with interval[i-1] because starting time of interval[i+1] 
	must be greater than or equal to interval[i]. Following is a detailed step by step algorithm.
	
1.	Sort intervals based on increasing order of Start_time.
2.  Push first interval on to a stack.
3.  For each subsequent interval do following:
   a. If current interval does not overlap with stack top, push it to stack.
   b. If current interval overlaps with stack top and END_time of current interval 
      is greater than stack top's END_time, update stack top with END_time of current interval.
4.    At the end, stack contains MERGED intervals. 
	
	[The problem we are dealing with here is part of a general more difficult  problem in Computer Science
	solved by an 'Interval Tree' or 'Segment Tree' Data structure. Interval Tree being a Data Structure holding 
	intervals. The study of this data structure and related algorithms is beyond the scope of this treatise ]

	
	A comparable Java implementation to above pseudocode follows further down in the document (findAll() method).
	[Complexity O(log n + m), where m resulting merged intervals, n number of intervals in Collections
	Initial creation time of O(n log n), memory consumption O(n). 
	Intervals are Sorted at the beginning of the Program according to Start_time 
	{see 'IntervalComparator' in code 'service' directory}
	On Intervals I check only on (Start_interval <= End_interval). If NOT true, I exit the program with a message.
	Negative and positive integers can be considered in intervals. 
	Input is ArrayList<Interval> intervals, Output is ArrayList<Interval> result]
	
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
				// end = MAX(Interval[i].end, Interval[i-1].end), 
				// 'end' gets the bigger value of the two, 
				// then keep moving the LOOP,'start' NOT changing yet!!
				
                end = Math.max(current.getEnd(), end);
				
            } else 		// non-overlapping interval, insert previous (start,end) to result List.
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
	
	