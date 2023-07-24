import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<arr.length-1; i++) {
            if(arr[i] != arr[i+1]) {
                stack.push(arr[i]);
                list.add(arr[i]);
            }
        }
            list.add(arr[arr.length-1]);
        answer = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}