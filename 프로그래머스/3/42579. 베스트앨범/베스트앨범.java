import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> idxPlay = new HashMap<>();
        Map<String, PriorityQueue<int[]>> personal = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            personal.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        }
        
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            personal.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
        List<Integer> res = new ArrayList<>();
       for (String key : list) {
           for (int j = 0; j < 2; j++) {
               if (!personal.get(key).isEmpty()) {
                   res.add(personal.get(key).poll()[1]);
               }
           }
       }
        
        int answer[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        
        return answer;
    }
}