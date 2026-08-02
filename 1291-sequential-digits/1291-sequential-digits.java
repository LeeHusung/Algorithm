import java.util.*;
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            String tmp = String.valueOf(i);
            for (int j = i + 1; j <= 9; j++) {
                tmp += j;
                int k = Integer.valueOf(tmp);
                if (k >= low && k <= high) {
                    list.add(k);
                }
            }
        }
        // System.out.println(list.toString());
        Collections.sort(list);
        return list;
    }
}