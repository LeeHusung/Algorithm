import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 처음 s의 모양 올바른 괄호인지 확인하고,
        // s의 인덱스0을 계속 맨 끝으로 보내서 괄호가 올바르면 ++
        // s의 길이만큼 반복
        for (int i = 0; i<s.length(); i++) {
            answer += (check(s)) ? 1 : 0;
            s = s.substring(1, s.length()) + s.substring(0,1);
        }
        return answer;
    }
        
        private static boolean check(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i<s.length(); i++) {
                if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                    continue;
                } else {
                    if (!stack.isEmpty()) {
                        if (s.charAt(i) == ']' && stack.pop() == '[') {
                            continue;
                        }
                        if (s.charAt(i) == '}' && stack.pop() == '{') {
                            continue;
                        }
                        if (s.charAt(i) == ')' && stack.pop() == '(') {
                            continue;
                        }
                        else {return false;}
                    }
                    else {return false;}
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {return false;}

        }
}  
