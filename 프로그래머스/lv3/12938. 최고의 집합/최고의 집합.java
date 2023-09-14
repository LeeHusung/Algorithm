class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        
        for (int i = 0; i<answer.length; i++) {
            if (s % n == 0) {
                answer[i] = s/n;
                continue;
            }
            else {
                answer[i] = s/n;
                int x = s%n;
                if (x>0) {
                    s++;
                }
                x--;
            }
        }
            
         
        
        
        return answer;
    }
}