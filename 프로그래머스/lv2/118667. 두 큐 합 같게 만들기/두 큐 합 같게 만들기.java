import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1; 
        
        long sum = 0;
        for (int i = 0; i<queue1.length; i++) {
            sum += queue1[i] + queue2[i];
        }
        
        long goal = sum/2;
        //sum이 홀수거나 queue에 goal보다 큰 값 있으면 return -1;
        if (sum%2 == 1) {
            return -1;
        }
        for (int i = 0; i<queue1.length; i++) {
            if (goal < queue1[i] || goal < queue2[i]) return -1;
        }
        
        //Queue에 담아주기
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i = 0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        long qsum1 = 0;
        long qsum2 = 0;
        for (int n : queue1) {
            qsum1 += n;
        }
        for (int n : queue2) {
            qsum2 += n;
        }
        
        //q전체합이 goal보다 클 때, goal보다 같거나 작아질 때까지 poll()해서 다른 q로 넘기면서 개수 세기
        int count = 0;
        while (count < queue1.length * 5) {
            
            if (qsum1 < qsum2) {
                qsum2 -= q2.peek();
                qsum1 += q2.peek();
                q1.add(q2.poll());
                count++;     
            } else if (qsum1 > qsum2) {
                qsum1 -= q1.peek();
                qsum2 += q1.peek();
                q2.add(q1.poll());
                count++;
            } else if (qsum1 == qsum2) {
                answer = count;
                break;
            } 
        }
        
        
        
        return answer;
    }
}