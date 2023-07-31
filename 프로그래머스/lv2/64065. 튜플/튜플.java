import java.util.*;
class Solution {
    public int[] solution(String s) {

        String[] sSplit = s.split("\\},\\{"); //why?
        
        sSplit[0] = sSplit[0].replaceAll("[{}]", "");
        sSplit[sSplit.length-1] = sSplit[sSplit.length-1].replaceAll("[{}]", "");
        System.out.println(sSplit[0]);
        
        int[] answer = new int[sSplit.length];
        String[][] sarrByLength = new String[sSplit.length][];
        
        //길이순 정렬
        for (int i = 0; i<sSplit.length; i++) {
            String[] sarr = sSplit[i].split(",");
            sarrByLength[sarr.length-1] = sarr;
        }
        
        Set<String> set = new HashSet<>();
        String[] list = new String[sSplit.length];
        
        for (int i = 0; i<sarrByLength.length; i++) {
            for (int j = 0; j<sarrByLength[i].length; j++) {
                if (!set.contains(sarrByLength[i][j])) {
                    list[i] = sarrByLength[i][j];
                    set.add(sarrByLength[i][j]);
                }
            }
        }
        
        for (int i = 0; i<list.length; i++) {
            answer[i] = Integer.parseInt(list[i]);
        }
        
        return answer;
    }
}