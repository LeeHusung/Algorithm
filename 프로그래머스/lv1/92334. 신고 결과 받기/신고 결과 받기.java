import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idMap = new HashMap<>(); //각각 번호 부여
        Map<String, HashSet<String>> map = new HashMap<>(); //신고받은자:신고자
        
        for (int i = 0; i<id_list.length; i++) {
            idMap.put(id_list[i], i);
            map.put(id_list[i], new HashSet<>()); //id별 set만들어서 누가 나 신고했는지 set으로 만듬
        }
        
        for (String s : report) {
            String[] sarr = s.split(" ");
            map.get(sarr[1]).add(sarr[0]); //id별 신고한사람들 set에 넣음
        }
        
        for (int i = 0; i<id_list.length; i++) {
            HashSet<String> set = map.get(id_list[i]);
            if (set.size() >= k) {
                for (String str : set) {
                    answer[idMap.get(str)]++;
                }
            }
        }
        
        
        return answer;
    }
}