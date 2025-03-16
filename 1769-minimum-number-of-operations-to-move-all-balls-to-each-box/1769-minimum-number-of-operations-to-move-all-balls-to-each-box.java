import java.util.*;
class Solution {
    public int[] minOperations(String boxes) {
        Set<Integer> set = new HashSet<>();
        char[] arr = boxes.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (String.valueOf(arr[i]).equals("1")) {
                set.add(i);
            }
        }

        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int x : set) {
                sum += Math.abs(x - i);
            }
            answer[i] = sum;
        }
        return answer;
    }
}