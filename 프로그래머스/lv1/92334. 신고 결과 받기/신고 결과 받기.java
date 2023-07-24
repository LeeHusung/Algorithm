import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idMap = new HashMap<>();
        Map<String, HashSet<String>> map = new HashMap<>();
        
        for (int i = 0; i<id_list.length; i++) {
            idMap.put(id_list[i], i);
            map.put(id_list[i], new HashSet<>());
        }
        
        for (String str : report) {
            String[] sarr = str.split(" ");
            map.get(sarr[1]).add(sarr[0]);
        }
        
        for (int i = 0; i<id_list.length; i++) {
            HashSet<String> set = map.get(id_list[i]);
            if (set.size() >= k) {
                for (String s : set) {
                    answer[idMap.get(s)]++;
                }
            }
        }
        
        
        
        return answer;
    }
}