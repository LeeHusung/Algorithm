import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;
        
        for (int i = 0; i<numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder sb = new StringBuilder(Long.toBinaryString(numbers[i]));
                
                if (sb.toString().contains("01")) {
                    for (int j = sb.length(); j>0; j--) {
                        if (sb.substring(j-2, j).equals("01")) {
                            sb.setCharAt(j-1, '0');
                            sb.setCharAt(j-2, '1');
                            break;
                        } 
                    }
                } else {
                        sb.deleteCharAt(0);
                        sb.insert(0, "10");
                    }
               answer[idx] = Long.valueOf(sb.toString(), 2);
            }
            idx++;
        }
        
        
        
        return answer;
    }
}