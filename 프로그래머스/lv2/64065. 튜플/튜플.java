import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        String[] sSplit = s.split("\\},\\{");
        sSplit[0] = sSplit[0].replaceAll("[{}]", "");
        sSplit[sSplit.length-1] = sSplit[sSplit.length-1].replaceAll("[{}]", "");
        
        // 길이 순 정렬
        String[][] sortByLength = new String[sSplit.length][];
        
        for (int i = 0; i<sSplit.length; i++) {
            String[] sarr = sSplit[i].split(",");
            sortByLength[sarr.length-1] = sarr;
        }
        // set에 넣고 값 구분
        Set<String> set = new HashSet<>();
        String[] list = new String[sSplit.length]; //중복x인 문자 넣기
        
        for (int i = 0; i<sortByLength.length; i++) {
            for (int j = 0; j<sortByLength[i].length; j++) {
                if (!set.contains(sortByLength[i][j])) {
                    list[i] = sortByLength[i][j];
                    set.add(sortByLength[i][j]);
                }
            }
        }
        
        int[] answer = new int[sSplit.length];
        
        for (int i = 0; i<list.length; i++) {
            answer[i] = Integer.parseInt(list[i]);
        }
        
        
        
        return answer;
    }
}
