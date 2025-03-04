class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] answer = new long[(int) nums.length];
        long[] conversion = new long[(int) nums.length];
        long max = 0;
        long sum = 0;

        int idx = 0;
        for (int x : nums) {
            max = Math.max(max, x);
            conversion[idx++] = max + x;
        }

        answer[0] = conversion[0];
        for (int i = 1; i < conversion.length; i++) {
            answer[i] = answer[i - 1] + conversion[i];
        }
        return answer;
    }
}