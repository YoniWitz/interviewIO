package intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineSweepIntro3 {
	static Interval[] mergeIntervals(Interval[] intervals) {
		if (intervals == null) {
			return null;
		}
		List<Point> points = new ArrayList<>();
		for (Interval el : intervals) {
			points.add(new Point(el.start, true));
			points.add(new Point(el.end, false));

		}
		Collections.sort(points);
		int count = 0;
		boolean flag = true;
		int i = 0;
		int newStart = 0;
		Interval[] mergedIntervals = new Interval[intervals.length];
		for (Point el : points) {
			count += el.isStart ? 1 : -1;
			if (count == 1 && flag) {
				flag = false;
				newStart = el.time;
			}
			if (count == 0) {
				flag = true;
				mergedIntervals[i++] = new Interval(newStart, el.time);
			}

		}
		return mergedIntervals;

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
		Interval[] intervals = new Interval[4];
		intervals[0] = new Interval(1, 3);
		intervals[1] = new Interval(6, 8);
		intervals[2] = new Interval(3, 5);
		intervals[3] = new Interval(7, 9);

		Interval[] mergedIntervals = (mergeIntervals(intervals));
		for (Interval el : mergedIntervals) {
			if (el != null)
				System.out.println("(" + el.start + " " + el.end + ")");
		}
	}
}
