import java.util.*;
class Solution {
    static int max = 0, cnt = 0;
    static int[] arr, a, b;
    static ArrayList<Integer> aList = new ArrayList<>();
    static ArrayList<Integer> bList = new ArrayList<>();
    static ArrayList<Integer> aRes = new ArrayList<>();
    static ArrayList<Integer> bRes = new ArrayList<>();
    public void D(int L, int start, int n, int[][] dice, int[] answer) {
        aList.clear();
        bList.clear();
        if (L == n/2) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    aList.add(i);
                } else bList.add(i);
            }
            calcul(dice);
        Collections.sort(aRes);
        Collections.sort(bRes);
        
        for (int i = 0; i < aRes.size(); i++) {
            int s = 0;
            int e = bRes.size();
            int k = 0;
            while (s + 1 < e) {
                int middle = (s + e) / 2;
                if (aRes.get(i) > bRes.get(middle)) {
                    s = middle;
                } else {
                    e = middle;
                }
            }
            cnt += s;
        }
        // System.out.println(cnt);
            if (cnt > max) {
                max = cnt;
                int idx = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 1) {
                        answer[idx++] = i + 1;
                    }
                }
            }
            cnt = 0;
            aRes.clear();
            bRes.clear();
            
        } else {
            for (int i = start; i < dice.length; i++) {
                arr[i] = 1;
                D(L + 1, i + 1, n, dice, answer);
                arr[i] = 0;
            }
        }
    }
    
    public void calcul(int[][] dice) {
        a = new int[aList.size()];
        b = new int[bList.size()];
        combine(0, dice);
    }
    
    public void combine(int L, int[][] dice) {
        if (L == a.length) {
            int aSum = 0, bSum = 0;
            for (int i = 0; i < a.length; i++) {
                aSum += a[i];
            }
            aRes.add(aSum);
            for (int i = 0; i < b.length; i++) {
                bSum += b[i];
            }
            bRes.add(bSum);
            return;
        
        }
            for (int j = 0; j < 6; j++) {
                a[L] = dice[aList.get(L)][j];
                b[L] = dice[bList.get(L)][j];
                combine(L + 1, dice);
            }
    }
    public int[] solution(int[][] dice) {
        int n = dice.length;
        arr = new int[n];
        int[] answer = new int[n / 2];
        for (int i = 0; i < dice.length; i++) {
            Arrays.sort(dice[i]);
        }
        
        D(0, 0, n, dice, answer);
       
        
        return answer;
    }
}