import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean visited[][][][] = new boolean[11][11][11][11];
    
    public int solution(String dirs) {
        int answer = 0;
        
        int index = 0;
        int x = 5; int y = 5;
        
        for (char ch : dirs.toCharArray()) {
            if (ch == 'U') {
                index = 0;
            } else if (ch == 'D') {
                index = 2;
            } else if (ch == 'R') {
                index = 3;
            } else if (ch == 'L') {
                index = 1;
            }
            int nx = x + dx[index];
            int ny = y + dy[index];
            
            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;
            
            if (visited[nx][ny][x][y] == false && visited[x][y][nx][ny] == false) {
                visited[nx][ny][x][y] = true;
                visited[x][y][nx][ny] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }
}
        
//         Set<Node> set = new HashSet<>();
        
//         int startX = 0;
//         int startY = 0;
//         Node node = new Node(startX, startY);
        
//         for (int i = 0; i<dirs.length(); i++) {
//             if (dirs.charAt(i) == 'L') {
//                 Node newNode = new Node(startX--, startY);
//                 if (newNode.getX() < -5) {
//                     startX = -5;
//                 }
//                 if (!set.contains(newNode)) {
//                     set.add(newNode);
//                 }
//             } else if (dirs.charAt(i) == 'R') {
//                 Node newNode = new Node(startX++, startY);
//                 if (newNode.getX() > 5) {
//                     startX = 5;
//                 }
//                 if (!set.contains(newNode)) {
//                     set.add(newNode);
//                 }
//             } else if (dirs.charAt(i) == 'U') {
//                 Node newNode = new Node(startX, startY++);
//                 if (newNode.getY() > 5) {
//                     startY = 5;
//                 }
//                 if (!set.contains(newNode)) {
//                     set.add(newNode);
//                 }
//             } else if (dirs.charAt(i) == 'D') {
//                 Node newNode = new Node(startX, startY--);
//                 if (newNode.getY() < -5) {
//                     startY = -5;
//                 }
//                 if (!set.contains(newNode)) {
//                     set.add(newNode);
//                 }
//             }
//         }
//         Iterator iter = set.iterator();
//         while (iter.hasNext()) {
//             System.out.println(iter.next());
//         }
        
        
        
//         return set.size();
//     }
    
//     static class Node {
//         private int x;
//         private int y;
        
//         Node (int x, int y) {
//             this.x = x;
//             this.y = y;
//         }
//         public int getX() {
//             return x;
//         }
//         public int getY() {
//             return y;
//         }
//     }
// }