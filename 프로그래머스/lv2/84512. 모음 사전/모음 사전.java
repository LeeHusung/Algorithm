import java.util.*;
class Solution {
    private static List<String> list;
    private static String[] sarr;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        sarr = new String[]{"A", "E", "I", "O", "U"};
        
        dfs("", 0);
        
        for (int i = 0; i<list.size(); i++) {
            if (word.equals(list.get(i))) {
                answer = i;
            }
        }
        
        return answer;
    }
    
    private void dfs(String str, int depth) {
        list.add(str);
        if (depth == 5) return;
        
        for (int i = 0; i<sarr.length; i++) {
            dfs(str + sarr[i], depth + 1);
        }
    }
}