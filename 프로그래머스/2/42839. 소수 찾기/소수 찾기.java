import java.util.*;
class Solution {
    static int answer;
    static int[] ch;
    static int n;
    Set<Integer> set = new HashSet<>();
    public void D(String[] s, String str) {
        if (!str.equals("")) {
            int x = Integer.parseInt(str);
            set.add(x);
        }
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    // str += s[i];
                    D(s, str +s[i]);
                    ch[i] = 0;
                }
            }
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public int solution(String numbers) {
        answer = 0;
        n = numbers.length();
        ch = new int[n];
        
        String[] s = numbers.split("");
        String str = "";
        D(s, str);
        
        for (int x : set) {
            if (isPrime(x)) answer++;
        }
        
        return answer;
    }
}