import java.util.*;
class Solution {
    static final int[] RATE = {90, 80, 70, 60};
    static int[] res;
    int n, m;
    int plus, totalCost;
    static int PLUS = 0, COST = 0;
    public void update(int[][] users, int[] emoticons, int[] res) {
        plus = 0;
        totalCost = 0;
        
        for (int[] user : users) {
            int userRate = user[0];
            int userHave = user[1];
            int cost = 0;
            for (int i = 0; i < res.length; i++) {
                if (100 - res[i] >= userRate) {
                    cost += emoticons[i] * res[i] / 100;
                } 
                if (cost >= userHave) {
                    plus++;
                    cost = 0;
                    break;
                }
            }
            totalCost += cost;
        }
        
        if (plus > PLUS) {
            PLUS = plus;
            COST = totalCost;
        } else if (plus == PLUS) {
            COST = Math.max(totalCost, COST);
        }
        
    }
    public void D(int[][] users, int[] emoticons, int L, int[] res) {
        if (L == m) {
            update(users, emoticons, res);
        } else {
            for (int i = 0; i < RATE.length; i++) {
                res[L] = RATE[i];
                D(users, emoticons, L+1, res);
            }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        n = users.length;
        m = emoticons.length;
        
        res = new int[m];
        
        D(users, emoticons, 0, res);
        
        return new int[]{PLUS, COST};
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     static int[][] ratio;
//     static int n, m;
//     static int[] result, compare, ch;
//     ArrayList<Integer> list = new ArrayList<>();
    
//     public void updateAnswer(int[][] users, int[] emoticons, ArrayList<Integer> list) {
        
//         for (int[] user : users) {
//             int rate = user[0];
//             int price = user[1];
//             for (int i = 0; i<list.size(); i++) {
//                 if ( )
//             }
//         }
//     }
    
//     public void D(int L) {
//         if (L == m) {
//             //플러스랑 판매액 계산해서 result에 담기. 플러스가 많다면 교체, 같다면 판매액으로 비교
//             updateAnswer(int[][] users, int[] emoticons, ArrayList<Integer> list);
//         } else {
//             for (int i = 0; i < 4; i++) {
//                 for (int j = 0; j < m; j++) {
//                     if (ch[j][i] == 0) {
//                         ch[j][i] = 1;
//                         list.add(ratio[j][i]);
//                         D(L + 1);
//                         ch[j][i] = 0;
//                     }
//                 }
//             }
//         }
//     }
    
//     public int[] solution(int[][] users, int[] emoticons) {
//         int[] answer = new int[2];
        
//         n = users.length;
//         m = emoticons.length;
        
//         result = new int[2];
//         compare = new int[m];
//         ch = new int[m];
//         ratio = new int[m][4];
//         for (int i = 0; i < m; i++) {
//             int k = emoticons[i] / 10;
//             int l = k;
//             for (int j = 0; j < 4; j++) {
//                 ratio[i][j] = emoticons[i] - k;
//                 k += l;
//             }
//         }
//         System.out.println(ratio[0][3]);
        
//         D(0);
        
//         return answer;
//     }
    
    
// }