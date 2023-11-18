import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        sb.deleteCharAt(0);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        
        String[] split = sb.toString().split("},\\{");

        Arrays.sort(split, (a, b) -> a.length() - b.length());
      
        int[] answer = new int[split.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] x = split[i].split(",");
            for (String k : x) {
                if (!list.contains(Integer.parseInt(k))) {
                    list.add(Integer.parseInt(k));
                }
            }
        }
        int idx = 0;
        for (int x : list) {
            answer[idx++] = x;
        }
        
        return answer;
    }
}