import java.util.*;
class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        if (s.length() == 1) {
            return 1;
        }

        //1. 1개의 문자
        char start = s.charAt(0);
        int cnt = 1;
        int onemax = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == start) {
                cnt++;
            } else {
                cnt = 1;
            }
            start = s.charAt(i);
            onemax = Math.max(onemax, cnt);
        }

        //2. 2개의 문자
        char[] ch = s.toCharArray();
        int res1 = two(ch, 'a', 'b');
        int res2 = Math.max(res1, two(ch, 'a', 'c'));
        int twomax = Math.max(res2, two(ch, 'b', 'c'));

        //3. 3개의 문자
        int threemax = 0;
        int a = 0, b = 0, c = 0;
        Map<String, Integer> strMap = new HashMap<>();
        strMap.put("0#0", -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a++;
            else if (s.charAt(i) == 'b') b++;
            else c++;
            int one = a - b;
            int two = a - c;
            String key = one + "#" + two;
            if (strMap.containsKey(key)) {
                threemax = Math.max(threemax, i - strMap.get(key));
            } else {
                strMap.put(key, i);
            }
        }


        return Math.max(onemax, Math.max(twomax, threemax));
    }

    private int two(char[] ch, char a, char b) {
        int max = 0;
        int i = 0;
        int n = ch.length;
        while(i < n) {
            while(i < n && (ch[i] != a && ch[i] != b)) {
                i++;
            }
            int diff = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, i - 1);
            while(i < n && (ch[i] == a || ch[i] == b)) {
                diff += (ch[i] == a ? 1 : -1);
                if (map.containsKey(diff)) {
                    max = Math.max(max, i - map.get(diff));
                } else {
                    map.put(diff, i);
                }
                i++;
            }
        }
        return max;
    }
}