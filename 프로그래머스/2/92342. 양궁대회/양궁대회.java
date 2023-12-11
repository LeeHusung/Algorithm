import java.util.ArrayList;
import java.util.Arrays;
class Solution {

    static int[] lion, ch;
    static int max;
    static ArrayList<int[]> answer = new ArrayList<>();

    public static void D(int start, int cnt, int[] info) {
        if (cnt == 0) {
            int score = compare(info, lion);
            if (score > 0) {
                if (score == max) answer.add(lion.clone());
                else if (score > max) {
                    max = score;
                    answer.clear();
                    answer.add(lion.clone());
                }
            }
            return;
        } else {
            for (int i = start; i < info.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    int arrow = info[i] + 1;
                    if (arrow > cnt) {
                        arrow = cnt;
                    }
                    lion[i] = arrow;
                    D(i, cnt - arrow, info);
                    ch[i] = 0;
                    lion[i] = 0;
                }
            }
        }
    }

    private static int compare(int[] info, int[] lion) {
        int lionScore = 0;
        int infoScore = 0;

        for (int i = 0; i < lion.length; i++) {
            if (lion[i] > 0 && lion[i] > info[i]) lionScore += 10 - i;
            if (info[i] > 0 && info[i] >= lion[i]) infoScore += 10 - i;
        }
        if (infoScore >= lionScore) return -1;
        return lionScore - infoScore;
    }

    public static int[] solution(int n, int[] info) {
        lion = new int[info.length];
        ch = new int[info.length];
        max = -1;
        D(0, n, info);
        int[] res = new int[10];
        if (answer.size() == 0) {
            return new int[]{-1};
        } else if (answer.size() == 1) {
            res = answer.get(0);
        } else {
            res = answer.get(0);
            for (int i = 1; i < answer.size(); i++) {
                res = compareLeast(res, answer.get(i));
            }
        }
        return res;
    }

    private static int[] compareLeast(int[] one, int[] ints) {
        for (int i = 10; i >= 0; i--) {
            if (one[i] > ints[i]) return one;
            if (ints[i] > one[i]) return ints;
        }
        return one;
    }
}
//     static int max;
//     static int[] lion, res, ch, answer;

//     public static void D(int cnt, int[] info, int k) {
//         if (cnt == 0) {
//             int appeachScore = 0;
//             int lionScore = 0;
//             for (int i = 0; i < info.length; i++) {
//                 if (lion[i] > 0 && lion[i] > info[i]) lionScore += 10 - i;
//                 if (info[i] > 0 && lion[i] <= info[i]) appeachScore += 10 - i; // <=로 하면 0, 0일때도 appeach점수가 플러스됨.
//             }
            
//             if (lionScore - appeachScore > max) {
//                 answer = res.clone();
//                 // res = check(res, lion);
//                 res = lion.clone();
//                 max = lionScore - appeachScore;
//             }
            
//         } else {
//             for (int i = 0; i < info.length; i++) {
//                 if (ch[i] == 0) {
//                     ch[i] = 1;
//                     lion[i] = info[i] + 1;
//                     D(cnt - lion[i], info, k);
//                     lion = new int[info.length];
//                     cnt = k;
//                     ch[i] = 0;
//                 }
//             }
//         }
//     }
//     public static int[] check(int[] a, int[] b) {
//         for (int i = 10; i >= 0; i--) {
//             if (a[i] > b[i]) return a;
//             if (a[i] < b[i]) return b;
//         }
//         return a;
//     }
//     public int[] solution(int n, int[] info) {
//         max = 0;
//         lion = new int[info.length];
//         answer = new int[info.length];
//         res = new int[info.length];
//         ch = new int[info.length];
     
//         int k = n;
//         D(n, info, k);
        
//         if (max == 0) {
//             res = new int[]{-1};
//         }
        
//         return res;
//     }
// }