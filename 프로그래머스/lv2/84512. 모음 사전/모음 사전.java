import java.util.*;
class Solution {
    private static String[] sarr;
    private static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        sarr = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();

        dfs(word, "", 0);
        
        for (int i = 0; i<list.size(); i++) {
            if (word.equals(list.get(i))) {
                answer = i;
            }
        }
        
        return answer;
    }

    private void dfs(String word, String str, int depth) {
        list.add(str);
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i<sarr.length; i++) {
            dfs(word, str + sarr[i], depth+1);
        }
    }
}