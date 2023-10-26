import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> pqMin = new PriorityQueue<>((a, b) -> a - b);
        LinkedList<Integer> dq = new LinkedList<>();
        
        for (String x : operations) {
            String[] s = x.split(" ");
            if (s[0].equals("I")) {
                dq.add(Integer.parseInt(s[1]));
                Collections.sort(dq, (a, b) -> a-b);
                // if (Integer.parseInt(s[1]) >= 0) pqMax.offer(Integer.parseInt(s[1]));
                // if (Integer.parseInt(s[1]) < 0) pqMin.offer(Integer.parseInt(s[1]));
            }
            if (s[0].equals("D")) {
                if (s[1].equals("-1")) dq.pollFirst();
                if (s[1].equals("1")) dq.pollLast();
            }
           
        }
        
        if (!dq.isEmpty()){
            answer[0] = dq.peekLast();
            answer[1] = dq.peekFirst();
        }
        else return new int[]{0, 0};
        
//         if (!pqMax.isEmpty()) {
//             answer[0] = pqMax.poll();
//         } else answer[0] = 0;
          
//         if (!pqMin.isEmpty()) {
//             answer[1] = pqMin.poll();
//         } else answer[1] = 0;
        
        return answer;
    }
}