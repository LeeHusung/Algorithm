class Solution {
    int sum;
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        sum = brown + yellow;
        int[] nums = new int[sum + 1];
        int[] result = new int[2];
        for(int i = 3; i <= sum; i++) {
            if (sum % i == 0) {
                int j = sum / i;
                if (j < i) break;
                 if ((i-2) * (j-2) == yellow && (i + j) * 2 == brown + 4 && i * j == sum) {
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }
        return answer;
//         answer[0] * answer[1] = sum;
//         answer[0-2] * answe[1 - 2] = yellow;
//         (answer[0] + answer[1]) * 2 = brown - 4;
        
        
        // return answer;
    }
}