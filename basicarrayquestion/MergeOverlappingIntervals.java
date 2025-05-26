package basicarrayquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

public static int[][] merge(int[][] intervals){

    // sort interval by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Step 2: Create list to hold merged intervals
    List<int[]> merged = new ArrayList<>();

    for (int i = 0; i< intervals.length; i++){
        int[] current = intervals[i];
        // If merged is empty or current interval does not overlap with the last merged interval
        if(merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]){
            merged.add(current);
        }else{
            // Overlap: merge the current interval with the last one
            int[] last = merged.get(merged.size() - 1);
            last[1] = Math.max(last[1], current[1]);
        }
    }
//    Convert list to array
    return merged.toArray(new int[merged.size()][]);
}
    public static void printIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + "," + intervals[i][1] + "] ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example 1
        int[][] input1 = { {1, 3}, {2, 6}, {8, 10}, {15, 18} };
        int[][] result1 = merge(input1);
        System.out.print("Output 1: ");
        printIntervals(result1);

        // Example 2
        int[][] input2 = { {1, 4}, {4, 5} };
        int[][] result2 = merge(input2);
        System.out.print("Output 2: ");
        printIntervals(result2);
    }
}
