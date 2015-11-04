package leetcode.mergeinterval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	/**
	 * Definition for an interval.
	 */
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		@Override
		public String toString() {
			return "{"+start+","+end+"}";
		}
	}

	public static class IntervalPoint implements Comparable<IntervalPoint> {
		int value;
		boolean start;
		
		IntervalPoint(int value, boolean start) {
			this.value = value;
			this.start=start;
		}

		@Override
		public int compareTo(IntervalPoint o) {
			if ( o == null ) {
				return -1;
			} else {
				if ( this == o ) {
					return 0;
				} else {
					if ( this.value == o.value ) {
						return ( this.start && !o.start) ? -1 : 1;
					} else {
						return this.value-o.value;					
					}
				}
			}
		}
		
		@Override
		public String toString() {
			return "{"+this.value+","+this.start+"}";
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		Set<IntervalPoint> set = new TreeSet<>();
		for(Interval interval: intervals) {
			set.add(new IntervalPoint(interval.start,true));
			set.add(new IntervalPoint(interval.end,false));
		}
		return mergeIntervalPoints(set);
	}
	
	public List<Interval> mergeIntervalPoints(Set<IntervalPoint> set) {
		List<Interval> output = new ArrayList<>();
		
		Iterator<IntervalPoint> i = set.iterator();
		int counter = 0;
		Interval interval = null;
		while( i.hasNext()) {
			IntervalPoint p = i.next();
			if ( counter == 0 ) {
				int start = p.value;
				interval = new Interval(start,start);				
			}
			if ( p.start ) {
				counter++;
			} else {
				counter--;
				if ( counter == 0 ) {
					interval.end = p.value;
					output.add(interval);
				}
			}
		}
		return output;
	}
	
	static void add(Set<IntervalPoint> set, int start, int end) {
		set.add(new IntervalPoint(start, true));
		set.add(new IntervalPoint(end, false));
	}
	public static void main(String[] args) {
		
		Set<IntervalPoint> set = new TreeSet<>();
		add(set,1,3);
		add(set,3,5);
		add(set,7,10);
		add(set,4,6);
		add(set,11,13);
		add(set,8,12);
		add(set,14,18);
		Iterator<IntervalPoint> i = set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println("***********");
		
		Solution s = new Solution();
		List<Interval> output = s.mergeIntervalPoints(set);
		for(Interval interval: output) {
			System.out.println(interval);
		}
	}
}