class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }

        for (int x : sum) {
            System.out.println(x);
        }

        int cnt = 0;
        for (int i = sum.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (k == sum[i] - sum[j]) cnt++;
            }
        }
        return cnt;
    }
}