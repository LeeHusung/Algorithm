class Solution {
    public int countPermutations(int[] complexity) {
        int first = complexity[0];
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= first) {
                return 0;
            }
        }

        int cnt = complexity.length - 1;

        long answer = 1;
        for (int i = cnt; i >= 1; i--) {
            answer = answer * i % 1_000_000_007;
        }
        return (int) answer;
    }
}