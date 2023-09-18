import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int n = topping.length;
        int[] arr1 = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        
        int idx = 0;
        for (int x : topping) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            arr1[idx++] = map.size();
        }
        map.clear();
        int[] arr2 = new int[n];
        for (int i = n-1; i>=0; i--) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            arr2[i] = map.size();
        }
        
        for (int i = 0; i<arr1.length-1; i++) {
            if (arr1[i] == arr2[i+1]) answer++;
        }
        
        return answer;
    }
}
