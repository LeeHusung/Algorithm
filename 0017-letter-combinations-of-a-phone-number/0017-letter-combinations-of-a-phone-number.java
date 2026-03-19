// 1. 브루트 포스?
// 2. 
import java.util.*;
class Solution {
    private String phoneDigits;
    private List<String> answer = new ArrayList<>();
        private Map<Character, String> letters = Map.of(
        '2',
        "abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );
    public void backtracking(int idx, StringBuilder sb) {
        if (sb.length() == phoneDigits.length()) {
            answer.add(sb.toString());
            return;
        }

        char x = phoneDigits.charAt(idx);
        String value = letters.get(x);
        for (char k : value.toCharArray()) {
            sb.append(k);
            backtracking(idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
     
    }

    public List<String> letterCombinations(String digits) {
        phoneDigits = digits;

        backtracking(0, new StringBuilder());
        return answer;
    }
}