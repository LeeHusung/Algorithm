import java.util.*;
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long start = 0;
        long end = Long.MAX_VALUE;
        while (start < end) {
            long middle = (start + end) / 2;
            if (can(middle, mountainHeight, workerTimes)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;

    }

    public boolean can(long time, int mountainHeight, int[] workerTimes) {
        long total = 0;
        for (int i = 0; i < workerTimes.length; i++) {
            int k = workerTimes[i];
            long left = 0;
            long right = mountainHeight;
            while (left < right) {
                long middle = (left + right + 1) / 2;
                long cost = k * middle * (middle + 1) / 2;
                if (cost > time) {
                    right = middle - 1;
                } else left = middle;
            }
            total += left;
            if (total >= mountainHeight) return true;
        }
        return false;
    }
}