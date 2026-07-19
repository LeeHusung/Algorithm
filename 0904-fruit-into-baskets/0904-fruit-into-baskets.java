import java.util.*;
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) return 1;
        //two pointer
        int i = 0;
        int j = 0;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        set.add(fruits[i]);
        while (j != fruits.length - 1) {
            j++;
            set.add(fruits[j]);
            if (set.size() > 2) {
                int tmp = j;
                set.clear();
                set.add(fruits[j]);
                while (tmp > 0) {
                    tmp--;
                    set.add(fruits[tmp]);
                    if (set.size() > 2) {
                        i = tmp + 1;
                        break;
                    }
                    // if (fruits[tmp] == fruits[i]) {
                    //     i = tmp + 1;
                    //     break;
                    // }
                }
                set.clear();
                set.add(fruits[i]);
                set.add(fruits[j]);
            }
            // System.out.println("j: " + j + ", i : " + i);
            // System.out.println(set.toString());
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}