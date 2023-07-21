import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i<moves.length; i++) {
            int move = moves[i];
            int findDoll = 0;
            for (int j = 0; j<board.length; j++){
                if (board[j][move-1] != 0) {
                    findDoll = board[j][move-1];
                    board[j][move-1] = 0;
                    break;
                }
            }
            if (findDoll != 0) {
                if (!stack.isEmpty() && findDoll == stack.peek()) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(findDoll);
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}