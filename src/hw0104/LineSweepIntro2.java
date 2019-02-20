package hw0104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineSweepIntro2 {
	static int maxOverlap(Interval[] intervals) {
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
		int maxCount = 0;
		for (Point el : points) {
			if (el.isStart) {
				count++;
			} else {
				count--;
			}
			if (count > 1)
				maxCount = Math.max(maxCount, count);
		}
		return maxCount;

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
		intervals[1] = new Interval(6, 9);
		intervals[2] = new Interval(4, 5);

		System.out.println(maxOverlap(intervals));
	}
}
