import java.util.*;
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int cnt1 = 1;
        int max1 = 1;
        for (int i = 0; i < hBars.length - 1; i++) {
            if (hBars[i] == hBars[i + 1] - 1) {
                cnt1++;
            } else cnt1 = 1;
            max1 = Math.max(max1, cnt1);
        }

        int cnt2 = 1;
        int max2 = 1;
        for (int i = 0; i < vBars.length - 1; i++) {
            if (vBars[i] == vBars[i + 1] - 1) {
                cnt2++;
            } else cnt2 = 1;
            max2 = Math.max(max2, cnt2);
        }
        // System.out.println(max1 + " " + max2);
        int result = Math.min(max1, max2);

        
        return (result + 1) * (result + 1);

    }
}