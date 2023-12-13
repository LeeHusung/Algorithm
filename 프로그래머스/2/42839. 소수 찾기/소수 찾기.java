import java.util.*;
class Solution {
    static int n, answer;
    static int[] ch;
    static LinkedList<Character> list = new LinkedList<>();
    static Set<Integer> set = new HashSet<>();
    public int checkSosu(LinkedList<Character> list) {
        String str = "";
        for (char x : list) {
            str += x;
        }
        int c = Integer.parseInt(str);    
        // System.out.println(c);
        if (c == 0 || c == 1) return 0;
        for (int j = 2; j <= Math.sqrt(c); j++) {
            if (c % j == 0) return 0;
        }
        return c;
    }
    
    public void D(int L, String numbers) {
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                list.add(numbers.charAt(i));
                int c = checkSosu(list);
                if (c != 0) set.add(c);
                D(L + 1, numbers);
                ch[i] = 0;
                list.pollLast();
            }
        }
    }
    public int solution(String numbers) {
        answer = 0;
        n = numbers.length();
        ch = new int[n];
        D(0, numbers);
        
        
        return set.size();
    }
}