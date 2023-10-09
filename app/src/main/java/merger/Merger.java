package merger;

import java.util.*;
import java.lang.*;

public class Merger{

	private static void reduce(List<int[]> list, int by){
		if (by >= list.size())
			list.clear();
		else
			list.subList(list.size() - by, list.size()).clear();
	}

	public static void mergeIntervals(List<int[]> intervals){
		// assumption: intervals are sorted
		int i = 0;
		while (i + 1 < intervals.size()){
			int[] a = intervals.get(i);
			int count = 0;
			// however many times this for loop runs, while loop will run that many
			// fewer times, so its still O(n)
			for (int j = i + 1;
					j < intervals.size() && intervals.get(j)[0] <= a[1];
					j ++){
				int[] b = intervals.get(j);
				a[1] = Math.max(b[1], a[1]);
				intervals.set(i, a); // TODO: is this necessary?
				b[0] = b[1] = -1;
				intervals.set(j, b); // TODO: is this necessary?
				count ++;
			}
			// see? however many times for ran, the while wont
			i += count + 1;
		}
		// now shift to remove the merged. O(n) after O(n) is still O(n)
		int shift = 0;
		while (i + shift < intervals.size()){
			int[] interval = intervals.get(i + shift);
			if (interval[0] == interval[1] && interval[0] == -1){
				shift ++;
				continue;
			}
			if (i != shift)
				intervals.set(i, interval);
			i ++;
		}
		// reduce length by shift
		reduce(intervals, shift);
	}
}
