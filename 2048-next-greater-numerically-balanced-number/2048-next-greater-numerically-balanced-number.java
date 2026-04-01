import java.util.*;
class Solution {
    public int nextBeautifulNumber(int n) {
        int x = n + 1;
        while (true) {
            if (isBalanced(x)) {
                return x;
            }
            x++;
        }
    }

    private boolean isBalanced(int x) {
        int[] cnt = new int[10];
        String str = String.valueOf(x);
        // System.out.println("str: " + str);
        for (int i = 0; i < str.length(); i++) {
            int k = str.charAt(i) - 48;
            if (k == 0) {
                // System.out.println("str22: " + str);
                return false;
            }
            // System.out.println("k: " + k);
            cnt[k]++;
        }
        boolean flag = true;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            if (cnt[i] != i) {
                return false;
            }
        }
        return flag;
    }
}