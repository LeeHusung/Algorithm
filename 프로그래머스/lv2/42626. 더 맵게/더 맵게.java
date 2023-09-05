import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for (int s : scoville) {
            q.add(s);
        }
        
        if (q.peek() >= K) return 0;
        
        while (q.size() > 1) {
            int newScoville = q.poll() + (q.poll() * 2);
            q.add(newScoville);
            answer++;
            if (q.peek() >= K) {
                return answer;
            }
        }
        
        if (q.peek() < K) return -1;
        
        return answer;
    }
}
        
//         List<Integer> list = new ArrayList<>();
//         Arrays.sort(scoville);
//         for (int i = 0; i<scoville.length; i++) {
//             list.add(scoville[i]);
//         }
        
//         if (list.get(0) >= K) {
//             return 0;
//         }
        
//         while (list.size() > 1) {
//             int newScoviile = list.get(0) + (list.get(1) * 2);
//             list.remove(list.get(0));
//             list.remove(list.get(0));
//             list.add(newScoviile);
//             // System.out.println(list);
//             answer++;
//             Collections.sort(list);
//             if (list.get(0) >= K) {
//                 return answer;
//             }
//         }
        
//         if (list.get(0) < K) {
//             return -1;
//         } 
//         return answer;
//     }
// }