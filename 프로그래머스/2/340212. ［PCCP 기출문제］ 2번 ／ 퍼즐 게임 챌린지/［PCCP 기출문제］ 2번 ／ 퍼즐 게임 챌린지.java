import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;
        
        long result = 0;
        long min = 1;
        long max = Integer.MAX_VALUE;
        
        while (min <= max) {
            //숙련도
            long middle = (min + max) / 2;
            long tmp = limit;
            for (int i = 0; i < n; i++) {
                int diff = diffs[i];
                int time = times[i];
                if (middle >= diff) {
                    tmp -= time;
                } else {
                    if (i >= 1) {
                        tmp -= (time + times[i - 1]) * (diff - middle) + time;
                    } else {
                        tmp -= time * (diff - middle) + time;
                    }
                }
            }
            if (tmp >= 0) {
                result = middle;
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        
        
        return (int) result;
    }
}