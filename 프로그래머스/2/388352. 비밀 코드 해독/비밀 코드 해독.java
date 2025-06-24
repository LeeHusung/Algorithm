import java.util.*;
class Solution {
    static int answer = 0;
    static Set<Integer>[] set;
    static int[] arr = new int[5];
    public int solution(int n, int[][] q, int[] ans) {
        set = new Set[q.length];
        int[] ch = new int[n + 1];
        for (int i = 0; i < q.length; i++) {
            set[i] = new HashSet<>();
            for (int j = 0; j < q[i].length; j++) {
                set[i].add(q[i][j]);
            }
        }
        D(0, 1, n, ch, q, ans);
        return answer;
    }
    
    private void D(int L, int start, int n, int[] ch, int[][] q, int[] ans) {
        if (L == 5) {
            for (int i = 0; i < set.length; i++) {
                int cnt = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (set[i].contains(arr[j])) cnt++;
                }
                if (cnt != ans[i]) return;
            }
            answer++;
            return;
        }
        for (int i = start; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                arr[L] = i;
                D(L + 1, i + 1, n, ch, q, ans);
                ch[i] = 0;
            }
        }
    }
}