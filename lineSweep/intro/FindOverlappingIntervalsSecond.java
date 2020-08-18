package intro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindOverlappingIntervalsSecond {

	public static void main(String[] str) {
		List<Interval> intervals = new ArrayList<Interval>() {{
			add(new Interval(LocalTime.of(5,0), LocalTime.of(7,0)));
			add(new Interval(LocalTime.of(1,0), LocalTime.of(3,0)));
			add(new Interval(LocalTime.of(6,0), LocalTime.of(9,0)));
			}};
		
			findIfOverLappingIntervals(intervals);
	}

	// [5,7],[1,3],[6,9] -> true
	// [5,7],[1,3],[7,9] -> false
	// solution : place all intervals in points and sort.
	// traverse through order and keep count. if there is more than one 'start' at a
	// time, return true.
	// return false
	public static boolean findIfOverLappingIntervals(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return false;
		int countIntervals = 0;

		List<Point> points = new ArrayList<>();
		Point point;
		for (Interval interval : intervals) {
			point = new Point(true, interval.start);
			points.add(point);
			point = new Point(false, interval.end);
			points.add(point);
		}

		Collections.sort(points);
		System.out.println(Arrays.toString(points.toArray()));
		return false;
	}
}

class Interval {
	LocalTime start;
	LocalTime end;
	
	public Interval(LocalTime start, LocalTime end) {
		this.start = start;
		this.end = end;
	}
}

class Point implements Comparable<Point> {
	boolean start;
	LocalTime time;

	public Point(boolean start, LocalTime time) {
		this.start = start;
		this.time = time;
	}

	@Override
	public int compareTo(Point point) {
		return this.time.compareTo(point.time);
	}

	@Override
	public String toString() {
		return this.time.toString();
	}
}