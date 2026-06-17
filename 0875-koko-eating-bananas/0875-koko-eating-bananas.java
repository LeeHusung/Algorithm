import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 1000000004;
        int min = 1;
        long answer = Long.MAX_VALUE;
        while (min <= max) {
            int middle = (max + min) / 2;
            long cnt = 0;
            for (int i = 0; i < piles.length; i++) {
                if (piles[i] % middle == 0) cnt += piles[i] / middle;
                else {
                    cnt += (piles[i] / middle) + 1;
                }
            }
            if (cnt > h) {
                min = middle + 1;
            } 
            else {
                answer = Math.min(answer, middle);
                max = middle - 1;
            }
        }
        return (int) answer;
    }
}