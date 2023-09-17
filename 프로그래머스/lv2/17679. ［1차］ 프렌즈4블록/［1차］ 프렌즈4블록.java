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
      for (int i = 0; i < m; i++) 
          for (int j = 0; j < n; j++) 
              ch[i][j] = board[i].charAt(j);

      boolean isUpdated = true;
      int countTotal=0;

      while(isUpdated){
          isUpdated=false;

          Set<Node> set=new HashSet<>();
          for(int i=1;i<m;i++){
              for(int j=1;j<n;j++){
                  char block=ch[i][j];
                  if(block!=' '&&block==ch[i-1][j]&&block==ch[i][j-1]&&block==ch[i-1][j-1]){
                      set.add(new Node(i,j));
                      set.add(new Node(i-1,j));
                      set.add(new Node(i,j-1));
                      set.add(new Node(i-1,j-1));
                  }
              }
          }

          // remove blocks and count them
          for(Node node:set){
              ch[node.x][node.y]=' ';
              isUpdated=true;
          }

         countTotal+=set.size();

         // shift blocks down
         for(int j=0;j<n;j++){
             Queue<Character> queue = new LinkedList<>();
             for(int i=m-1;i>=0;i--){
                 if(ch[i][j]!=' ') {
                     queue.offer(ch[i][j]);
                     ch[i][j]=' ';
                 }
             }

             int index=m-1;
             while(!queue.isEmpty()){
                 ch[index--][j]=queue.poll(); //큐에서 값 꺼내서 ch 2차원배열 다시 초기화.
             }
         }
     }

     return countTotal;

   }  
}
