import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        
        // 초기 사전 설정 (단일 문자를 코드로 매핑)
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        int nextIndex = 27; // 다음 사용 가능한 색인 번호
        
        int i = 0;
        while (i < msg.length()) {
            int j = i + 1;
            // 사전에서 찾을 수 있는 가장 긴 문자열을 찾음
            while (j <= msg.length() && dictionary.containsKey(msg.substring(i, j))) {
                j++;
            }
            j--; // j를 사전에서 찾은 문자열의 끝 인덱스로 조정
            
            // 사전에서 찾은 문자열에 해당하는 색인 번호를 출력 리스트에 추가
            answerList.add(dictionary.get(msg.substring(i, j)));
            
            // 다음에 올 문자열을 사전에 추가
            if (j < msg.length()) {
                dictionary.put(msg.substring(i, j + 1), nextIndex);
                nextIndex++;
            }
            
            i = j; // 다음 처리할 위치로 인덱스 업데이트 (j만큼 이동)
        }
        
        // 리스트를 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int k = 0; k < answerList.size(); k++) {
            answer[k] = answerList.get(k);
        }
        
        return answer;
    }
}
