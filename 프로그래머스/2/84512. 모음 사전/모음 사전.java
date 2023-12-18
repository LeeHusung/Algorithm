import java.util.*;
class Solution {
    int answer;
    String[] w;
    boolean flag;
    public void D(int L, String word, StringBuilder sb) {
        if (flag) return;
        // System.out.println(sb.toString());
        answer++;
        if (word.equals(sb.toString())) {
            flag = true;
            return;
        }
        if (L == 5) return;
        for (int i = 0; i < w.length; i++) {
            sb.append(w[i]);
            D(L + 1, word, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public int solution(String word) {
        answer = 0;
        flag = false;
        w = new String[] {"A", "E", "I", "O", "U"};
        StringBuilder sb = new StringBuilder();
        D(0, word, sb);
        
        return answer - 1;
    }
}