import java.util.*;

class Node {
    public int x;
    public int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution {
    
  public int solution(int m, int n, String[] board) {
      Character[][] ch = new Character[m][n];
     
      
      for (int i = 0; i<m; i++) {
          for (int j = 0; j<n; j++) {
             ch[i][j] = board[i].charAt(j);
          }
      }
      boolean isTrue = true;
      int count = 0;
      while (isTrue) {
          isTrue = false;
          Set<Node> set = new HashSet<>();
          
          for (int i = 0; i<ch.length-1; i++) {
              for (int j = 0; j<ch[i].length-1; j++) {
                  if (ch[i][j] != ' ' && ch[i][j] == ch[i+1][j] && ch[i][j] == ch[i][j+1] && ch[i][j] == ch[i+1][j+1]) { //ch[i][j] != ' '이 코드가 없으면 ' '인 값들도 다 조건에 맞게되니까 set에 추가됨. ' '면 생략해야되기때문에 있어야됨.
                      set.add(new Node(i, j));
                      set.add(new Node(i+1, j));
                      set.add(new Node(i, j+1));
                      set.add(new Node(i+1, j+1));
                  }
              }
          }
          
          count += set.size();
          
          for (Node node : set) {
              ch[node.x][node.y] = ' ';
              isTrue = true;
          }
          
          //내리기
          for (int j = 0; j<n; j++) {
              Queue<Character> q = new LinkedList<>();
              for (int i = m-1; i >= 0; i--) {
                  if (ch[i][j] != ' ') {
                      q.add(ch[i][j]);
                      ch[i][j] = ' ';
                  }
              }
              int idx = m-1;
              while (!q.isEmpty()) {
                  ch[idx--][j] = q.poll();
              }
          }
      }
      
      return count;
   }  
}
