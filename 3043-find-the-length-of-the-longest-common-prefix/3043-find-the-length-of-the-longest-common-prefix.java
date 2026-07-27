import java.util.*;
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        SortedSet<Integer> set1 = new TreeSet<>((a, b) -> b - a);
        SortedSet<Integer> set2 = new TreeSet<>((a, b) -> b - a);

        for (int arr : arr1) {
            while (arr > 0) {
                set1.add(arr);
                arr /= 10;
            }
        }
        for (int arr : arr2) {
            while (arr > 0) {
                set2.add(arr);
                arr /= 10;
            }
        }

        int max = 0;
        boolean flag = false;
        // System.out.println(set1.size());
        // System.out.println(set2.size());
        for (int x : set1) {
            if (set2.contains(x)) {
                return String.valueOf(x).length();
            }
        }
        if (!flag) return 0;
        return String.valueOf(max).length();

    }
}