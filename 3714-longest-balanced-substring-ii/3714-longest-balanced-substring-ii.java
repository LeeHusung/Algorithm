import java.util.*;
class Solution {
    public int longestBalanced(String s) {
        int max = 0;
        char[] ch = s.toCharArray();
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
        max = Math.max(onemax, two(ch, 'a', 'b'));
        max = Math.max(max, two(ch, 'a', 'c'));
        max = Math.max(max, two(ch, 'b', 'c'));

        return Math.max(max, three(ch));
    }

    private int two(char[] ch, char a, char b) {
        int n = ch.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            while(i < n && (ch[i] != a && ch[i] != b)) {
                i++;
            }
            Map<Integer, Integer> map = new HashMap<>();
            int diff = 0;
            map.put(0, i - 1);
            while (i < n && (ch[i] == a || ch[i] == b)) {
                diff += (ch[i] == a ? 1 : -1);
                if (map.containsKey(diff)) {
                    res = Math.max(res, i - map.get(diff));
                } else {
                    map.put(diff, i);
                }
                i++;
            }
        }
        return res;
    }

    
    private int three(char[] ch) {
        int n = ch.length;
        int res = 0, a = 0, b = 0, c = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'a') a++;
            else if (ch[i] == 'b') b++;
            else c++;
            int one = a - b;
            int two = b - c;
            String key = one + "#" + two;
            if (map.containsKey(key)) {
                res = Math.max(res, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return res;
    }
}