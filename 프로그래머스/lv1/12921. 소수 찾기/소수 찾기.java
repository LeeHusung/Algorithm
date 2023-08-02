import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
       
        boolean sosu;
        for (int i = 2; i<=n; i++) {
            sosu = true;
            for (int j = 2; j<=Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sosu = false;
                    break;
                }
            }
            if(sosu) {answer++;}
        }
        
        
        
        return answer;
    }
}