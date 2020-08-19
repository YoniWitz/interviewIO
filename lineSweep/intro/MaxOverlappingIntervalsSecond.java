package intro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxOverlappingIntervalsSecond {

	public static void main(String[] str) {

		@SuppressWarnings("serial")
		List<Interval> intervals = new ArrayList<Interval>() {
			{
				add(new Interval(LocalTime.of(5, 0), LocalTime.of(7, 0)));
				add(new Interval(LocalTime.of(1, 0), LocalTime.of(3, 0)));
				add(new Interval(LocalTime.of(7, 0), LocalTime.of(9, 0)));
				add(new Interval(LocalTime.of(6, 0), LocalTime.of(8, 0)));
			}
		};

		System.out.println(findMaxOverLappingIntervals(intervals));
	}

	// [5,7],[1,3],[7,9] -> 2
	// [5,7],[1,3],[7,9],[6,8] -> 3
	// solution : place all intervals in points and sort.
	// traverse through points and keep count of intervals and maxintervals
	public static int findMaxOverLappingIntervals(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0)
			return -1;
		int countIntervals = 0;
		int maxIntervals = 0;

		List<Point> points = new ArrayList<>();
		Point tempPoint;
		for (Interval interval : intervals) {
			tempPoint = new Point(true, interval.start);
			points.add(tempPoint);
			tempPoint = new Point(false, interval.end);
			points.add(tempPoint);
		}

		Collections.sort(points);
		for (Point point : points) {
			countIntervals = point.start == true ? countIntervals + 1 : countIntervals - 1;
			maxIntervals = Math.max(maxIntervals, countIntervals);
		}
		return maxIntervals;
	}
}
