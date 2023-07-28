import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String[] city = new String[cities.length];
        
        List<String> list = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (int i = 0; i<cities.length; i++) {
            city[i] = cities[i].toLowerCase();
        }
        
        for (int i = 0; i<city.length; i++) {
            if (list.contains(city[i])){
                answer += 1;
                list.remove(city[i]);
                list.add(city[i]);
            } else {
                if (list.size() >= cacheSize) { //리스트가 캐시크기보다 커지면 리스트 0번 인덱스 제거
                    list.remove(0);
                }
                list.add(city[i]);
                answer += 5;
            }
        }
        
        
        
        return answer;
    }
}
