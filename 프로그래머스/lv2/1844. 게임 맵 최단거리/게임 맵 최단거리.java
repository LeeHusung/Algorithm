import java.util.*;
class Solution {
    
    int[] dx = {0, 1, 0, -1}; //이동 방향 나타내는 배열. 상하좌우
    int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
    
    
    private void bfs(int[][] maps, int[][] visited) {
        
        int x = 0;
        int y = 0;
        visited[x][y] = 1; //처음 출발
        
        Queue<int[]> q = new LinkedList<>(); //먼저 들어간게 먼저 나올 수 있게
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i<4; i++) {
                int bx = cx + dx[i];
                int by = cy + dy[i];
                
                if (bx < 0 || bx > maps.length-1 || by < 0 || by > maps[0].length-1) continue;
                if (visited[bx][by] == 0 && maps[bx][by] == 1) {
                    visited[bx][by] = visited[cx][cy] + 1;
                    q.add(new int[]{bx, by});
                } 
            }
        }
        
        
        
        
    }
}