import java.util.*;
class Solution {
    static int[] ch;
    Queue<Integer> q = new LinkedList<>();
    
    public int B(int x, int y, int n) {
        ch = new int[1000001];
        q.offer(x);
        ch[x] = 1;
        int L = 0;
        
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i<len; i++) {
                int nx = q.poll();
                if (nx == y) return L;
                for (int j = 0; j<3; j++) {
                    int one = nx + n;
                    int two = nx * 2;
                    int three = nx * 3;
                    if (one <= 1000000 && ch[one] == 0) {
                        q.offer(one);
                        ch[one] = 1;
                    }
                    if (two <= 1000000 && ch[two] == 0) {
                        q.offer(two);
                        ch[two] = 1;
                    }
                    if (three <= 1000000 && ch[three] == 0) {
                        q.offer(three);
                        ch[three] = 1;
                    }
                    
                }
            }
            L++;
            
            
        }
        return -1;
    }
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        answer = B(x, y, n);
        
        return answer;
    }
}   
        
