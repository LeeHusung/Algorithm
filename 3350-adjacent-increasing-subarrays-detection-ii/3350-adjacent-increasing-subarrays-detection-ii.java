import java.util.*;
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int result = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        int tmp = 1;
        
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) < nums.get(i + 1)) {
                tmp++;
                continue;
            } else {
                list.add(tmp);
                tmp = 1;
            }
        }
        list.add(tmp);

        int prev = 0;
        for (int x : list) {
            result = Math.max(result, x / 2);
            int k = Math.min(prev, x);
            prev = x;
            result = Math.max(result, k);
        }


        return result;
    }
}