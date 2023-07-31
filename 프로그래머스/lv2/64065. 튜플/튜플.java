import java.util.*;
class Solution {
    public int[] solution(String s) {
        
       String[] sSplit = s.split("\\},\\{");     
        // ["{{2", "2,1", "2,1,3", "2,1,3,4}}"]

        // 배열의 가장 앞 문자열, 배열의 가장 뒷 문자열에서 '{' , '}' 문자 제거
        sSplit[0] = sSplit[0].replaceAll("[{}]","");
        sSplit[sSplit.length-1] = sSplit[sSplit.length-1].replaceAll("[{}]","");
        // ["2", "2,1", "2,1,3", "2,1,3,4"]
        
        // System.out.println(sSplit[0]);
        // System.out.println(sSplit[sSplit.length-1]);
        int[] answer = new int[sSplit.length];
        
        
         String[][] sarr = new String[sSplit.length][];

        for (int i = 0 ; i < sSplit.length ; i++) {
            String[] ss = sSplit[i].split(",");
            sarr[ss.length-1] = ss;
            //System.out.println(Arrays.toString(sortedByLength[ss.length-1]));
        }
        Set<String> set = new HashSet<>();
        String[] list = new String[sSplit.length]; //정답배열
        
        for (int i = 0; i<sarr.length; i++) {
            for (int j = 0; j<sarr[i].length; j++) {
                if (!set.contains(sarr[i][j])) {
                    list[i] = sarr[i][j];
                    set.add(sarr[i][j]);
                }
            }
        }        
        
        for (int i = 0; i<list.length; i++) {
            answer[i] = Integer.parseInt(list[i]);
        }
        
        
        return answer;
    }
}