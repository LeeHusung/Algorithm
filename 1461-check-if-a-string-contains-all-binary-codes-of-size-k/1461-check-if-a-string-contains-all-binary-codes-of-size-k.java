import java.util.*;
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);
            if (set.contains(sub)) continue;
            set.add(sub);
        }
        // for (String se : set) {
        //     System.out.println(se);
        // }

        int cnt = 1;
        for (int i = 0; i < k; i++) {
            cnt *= 2;
        }
        
        return set.size() == cnt;
    }
}