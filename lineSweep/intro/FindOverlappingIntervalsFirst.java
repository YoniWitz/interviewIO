package intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindOverlappingIntervalsFirst {
	static int overlap(Interval[] intervals) {
		if (intervals == null) {
			return -1;
		}
		List<Point> points = new ArrayList<>();
		for (Interval el : intervals) {
			points.add(new Point(el.start, true));
			points.add(new Point(el.end, false));
		}
		
		Collections.sort(points);
		
		int count = 0;
		for (Point el : points) {
			if (el.isStart) {
				count++;
			} else {
				count--;
			}
			if (count > 1) {
				return 1;
			}
		}
		return 0;
	}

	static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static class Point implements Comparable<Point> {
		int time;
		boolean isStart;

		Point(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(Point other) {
			if (other.time == this.time) {
				if (this.isStart == other.isStart)
					return 0;
				if (this.isStart)
					return -1;
				if (!this.isStart)
					return 1;
			}
			return this.time < other.time ? -1 : 1;
		}
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(1, 3);
		intervals[1] = new Interval(8, 9);
		intervals[2] = new Interval(5, 7);

		System.out.println(overlap(intervals));
	}
}
