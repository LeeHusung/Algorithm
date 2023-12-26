class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        String color = board[h][w];
        
        int count = 0;
        for (int i = 0; i < 4; i ++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny].equals(color)) count++; 
        }
        
        return count;
    }
}