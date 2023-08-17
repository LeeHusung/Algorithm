import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i<26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i+1);
        }
        
        int next = 27;
        int i = 0;
        while (i < msg.length()) {
            int j = i+1;
            while (j <= msg.length() && map.containsKey(msg.substring(i, j))) {
                j++; //map이 가지고 있는 최대 길이 단어 구하기
            }
            j--; //list에 넣을 인덱스 구하기
            
            list.add(map.get(msg.substring(i, j)));
            
            //msg의 길이 안넘는다면 뒤에 한 문자 추가해서 map에 더하기. 넘으면 반복 다 돈거임.
            if (j < msg.length()) {
                map.put(msg.substring(i, j+1), next);
                next++;
            }
            
            //list에 값 넣은 다음 단어부터 반복
            i = j;
        }
        
        int[] answer = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            answer[k] = list.get(k);
        }
        
        
        
        return answer;
    }
}