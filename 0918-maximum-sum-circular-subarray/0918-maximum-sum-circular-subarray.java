class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int answer = 0;
        int curMax = 0;
        int curMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            curMax = Math.max(num, num + curMax);
            max = Math.max(max, curMax);

            curMin = Math.min(num, num + curMin);
            min = Math.min(min, curMin);
        }
        if (max < 0) {
            return max;
        }

        return Math.max(max, sum - min);
    }
}