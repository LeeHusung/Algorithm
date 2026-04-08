import java.util.*;
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int result = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        int tmp = 1;
        int prev = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                tmp++;
            } else {
                prev = tmp;
                tmp = 1;
            }
            result = Math.max(result, tmp / 2);
            result = Math.max(result, Math.min(prev, tmp));
        }

        return result;
    }
}