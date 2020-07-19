package learning;

import java.util.*;

public class FindPairs {
    public static void main(String[] args) {
        // [14, 13, 6, 7, 8, 10, 1, 2] with target 3, print "1 2"
        int[] arr = { 14, 13, 6, 7, 8, 10, 1, 2 };
        int sum = 8;
        // can sort that with merge sort then
        var s = new HashSet<Integer>();
        var result = new HashSet<String>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];
            // checking for condition
            if (s.contains(temp)) {
                result.add("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
            }
            s.add(arr[i]);
        }
    }
}
