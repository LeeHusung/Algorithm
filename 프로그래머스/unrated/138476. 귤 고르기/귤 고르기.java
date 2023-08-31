import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        //많이 나온 순서대로 k개보다 적거나 같을때까지넣어. 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        // System.out.println(map.values());
        
        // 정렬
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int count = 0;
        for (int i : list) {
            count += i;
            answer++;
            if (count >= k) {
                break;
            } else continue;
        }
       
        
        return answer;
    }
}