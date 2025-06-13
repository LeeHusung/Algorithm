import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> a = new ArrayDeque<>();
        Queue<Integer> b = new ArrayDeque<>();
        
        long sum = 0;
        for (int x : queue1) {
            sum += x;
            a.offer(x);
        }
        for (int x : queue2) {
            sum += x;
            b.offer(x);
        }
        if (sum % 2 == 1) {
            return -1;
        }
        long goal = sum / 2;
        
        long aSum = 0;
         for (int x : queue1) {
            aSum += x;
        }
        
        long bSum = 0;
         for (int x : queue2) {
            bSum += x;
        }
        int cnt = 0;
        while (cnt <= queue1.length * 3 - 1) {
            if (aSum == goal) {                
                return cnt;
            }
            if (aSum < goal) {
                int p = b.poll();
                a.offer(p);
                cnt++;
                bSum -= p;
                aSum += p;
            }
            if (aSum == goal) {                
                return cnt;
            }
             if (aSum > goal) {
                int p = a.poll();
                b.offer(p);
                cnt++;
                aSum -= p;
                bSum += p;
            }
            if (aSum == goal) {                
                return cnt;
            }
        }
        
        return answer;
    }
}