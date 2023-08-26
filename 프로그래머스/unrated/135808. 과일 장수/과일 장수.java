import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        // List<Integer> list = new ArrayList<>();
        // for (int i : score) {
        //     list.add(i);
        //     if (list.size() == m) {
        //         System.out.println(answer);
        //         answer += list.get(list.size()-1) * m;
        //         list.clear();
        //     }
        // }
        for (int i = score.length-m; i>=0; i -=m) {
            answer += score[i] * m;
        }
         
        return answer;
    }
}