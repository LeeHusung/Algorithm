import java.util.*;
class Solution {
    public long solution(int n) {
        long answer = 0;
        
        Map<Integer, Long> map = new HashMap<>();
        
        map.put(1, 1l);
        map.put(2, 2l);
        map.put(3, 3l);
        map.put(4, 5l);
        
        int idx = 5;
        while (idx<=2000) {
            map.put(idx, (map.get(idx-1) + map.get(idx-2)) % 1234567);
            idx++;
        }
        
        
        
        return map.get(n);
    }
}