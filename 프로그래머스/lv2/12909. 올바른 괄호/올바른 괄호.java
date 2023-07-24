import java.util.Stack;
class Solution {
    boolean solution(String s) {
     
//         int open = 0;
//         int close = 0;
        
//         for(int i = 0; i<s.length(); i++) {
//             if(s.charAt(i) == '('){
//                 open++;
//             } else if(s.charAt(i) == ')'){
//                 close++;
//             }
//             if(open < close) {
//                 return false;
//             }
//         }
//         if(open == close) {
//             return true;
//         } else {
//             return false;
//         }
        
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            } else if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
