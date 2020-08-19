package intro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeOverlappingIntervalsSecond {
	public static void main(String[] str) {
		@SuppressWarnings("serial")
		List<Interval> intervals = new ArrayList<Interval>() {
			{
				add(new Interval(LocalTime.of(1, 0), LocalTime.of(3, 0)));
				add(new Interval(LocalTime.of(2, 0), LocalTime.of(4, 0)));
				add(new Interval(LocalTime.of(3, 0), LocalTime.of(5, 0)));
				add(new Interval(LocalTime.of(6, 0), LocalTime.of(8, 0)));
				add(new Interval(LocalTime.of(7, 0), LocalTime.of(9, 0)));
			}
		};

		System.out.println(Arrays.toString(mergeOverlappingIntervals(intervals).toArray()));
	}

	// (1,3), (2,4), (3,5), (6,8), (7,9) -> (1,5), (6,9)
	// solution : place all intervals in points and sort.
	// traverse through points and keep count. if there is more than one 'start' at
	// a time, remove until start is less than 2
	// test: after flattening: [1,2,3,3,4,5,6,7,8,9] ->
	// return false
	public static List<Point> mergeOverlappingIntervals(List<Interval> intervals) {
		if (intervals == null)
			return null;

		int countIntervals = 0;
		List<Point> points = new ArrayList<>();
		Point tempPoint;
		for (Interval interval : intervals) {
			tempPoint = new Point(true, interval.start);
			points.add(tempPoint);
			tempPoint = new Point(false, interval.end);
			points.add(tempPoint);
		}

		Collections.sort(points);
		for (int i = 0; i < points.size();) {
			if (points.get(i).start == true) {
				countIntervals++;
				if (countIntervals > 1) {
					points.remove(i);
				}
				else {
					i++;
				}
			}
			else {
			countIntervals--;
				if (countIntervals >0) {
					points.remove(i);
				}
				else {
					i++;
				}
			}
		}
		return points;
	}
}
