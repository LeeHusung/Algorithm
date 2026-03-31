class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int res = 0;
        int[] tmp = new int[value];
        
        for (int x : nums) {
            int mod = (x % value + value) % value;
            tmp[mod]++;
        }

        while (tmp[res % value] > 0) {
            tmp[res % value]--;
            res++;
        }

        return res;
    }
}