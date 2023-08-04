import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        //합집합 구하고, 교집합 구하면 끝. 기타 공백이나 숫자, 특수 문자는 무시
        //합집합 = 전체집합 - 교집합
        //교집합 먼저 구하기
        
        String st1 = str1.toLowerCase();
        String st2 = str2.toLowerCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        //배열에 모든 값 다 담기
        String str = new String();
        for (int i = 0; i<st1.length()-1; i++) {
            str = st1.substring(i, i+2);
            if (str.matches("^[a-z]*$")) list1.add(str);
        }
        for (int i = 0; i<st2.length()-1; i++) {
            str = st2.substring(i, i+2);
            if (str.matches("^[a-z]*$")) list2.add(str);
        }
        
        if (list1.size() == 0 && list2.size() == 0) {
            answer = 65536;
        } else {    
            int count = 0;
            for (int i = 0; i<list1.size(); i++) {
                str = list1.get(i);
                if (list2.contains(str)) {
                    count++; //교집합
                    list1.remove(str);
                    list2.remove(str);
                    i--; //다시 처음부터 반복 돌려
                }
            }
        answer = (int) ((double) count / (count + list1.size() + list2.size()) * 65536);
        }
     
        return answer;
    }
}