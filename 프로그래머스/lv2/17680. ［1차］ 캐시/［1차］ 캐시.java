import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        String[] city = new String[cities.length];
        
        for (int i = 0; i<cities.length; i++) {
            city[i] = cities[i].toLowerCase();
        }
        
        List<String> list = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }   for (int i = 0; i < city.length; i++) {
            if (list.contains(city[i])) {
                // Cache hit: 해당 도시 이름을 삭제하고 가장 최근으로 추가
                list.remove(city[i]);
                list.add(city[i]);
                answer += 1;
            } else {
                // Cache miss: 가장 오래된 항목 제거하고 새로운 항목 추가
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(city[i]);
                answer += 5;
            }
        }
        
        return answer;
    }
}