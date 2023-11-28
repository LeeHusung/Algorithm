import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int s = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            while (true) {
                if (q.isEmpty()) {
                    q.offer(truck_weights[i]);
                    time++;
                    s += truck_weights[i];
                    break;
                } else if (q.size() == bridge_length) {
                    s -= q.poll();
                } else {
                    if (s + truck_weights[i] > weight) {
                        q.offer(0);
                        time++;
                    } else {
                        q.offer(truck_weights[i]);
                        time++;
                        s += truck_weights[i];
                        break;
                    }
                }
            }
            // if (q.size() == bridge_length) {
            //     time += bridge_length;
            //     s -= q.poll();
            //     continue;
            // }
            // s += truck_weights[i];
            // if (s <= weight) {
            //     q.offer(truck_weights[i]);
            //     time++;
            //     continue;
            // } else {
            //     s -= q.poll();
            //     time += bridge_length;
            // }
            

        }
        
        return time + bridge_length;
    }
}