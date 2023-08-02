import java.util.*;
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
class Solution {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static char[][] map;
    static Queue<Node> q = new LinkedList<>();
    static int n;
    static int m;
    public int[] solution(String[] maps) {
        
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        map = new char[n][m];
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        List<Integer> list = new ArrayList<>(); 
        for (int i = 0; i<map.length; i++) {
            for (int j = 0; j<map[i].length; j++) {
                if (map[i][j] != 'X' && visited[i][j] != true) {
                    q.add(new Node(i, j)); //q가 빌때까지 반복돌리고 q가 비면 모두 탐색 완료된거.
                    list.add(bfs(i, j)); //bfs가 한 사이클 돌아가면 add.
                }
            }
        }
        
        
        if (list.size() == 0) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        } 
        
        Arrays.sort(answer);
         
        return answer;
    }
    
    public int bfs(int x, int y) {
        visited[x][y] = true; //방문처리
        int count = 0;
        
        while (!q.isEmpty()) {
            
            Node node = q.poll();
            int nodex = node.x;
            int nodey = node.y;
            
            count += map[nodex][nodey] - 48; //아스키코드로 노드에 있는 real숫자 구하기
            
            for (int i = 0; i<4; i++) {
                int movex = nodex + dx[i];
                int movey = nodey + dy[i];
                if (movex < 0 || movex >= n || movey < 0 || movey >= m) continue;
                if (map[movex][movey] != 'X' && visited[movex][movey] != true) {
                    q.add(new Node(movex, movey));
                    visited[movex][movey] = true;
                }
            }
        }
      
        return count;
    }
}