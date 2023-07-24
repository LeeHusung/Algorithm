import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack();
        
        for(int a : arr) {
            if (stack.isEmpty() || a != stack.peek()) {
                stack.add(a);
            }
        }
        
        answer = new int[stack.size()];
        
        int idx = 0;
        for (int a : stack) {
            answer[idx] = a;
            idx++;
        }
        
        return answer;
    }
}