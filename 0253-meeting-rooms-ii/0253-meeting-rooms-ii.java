import java.util.*;
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int answer = Integer.MIN_VALUE;
        for(int[] arr : intervals) {
            if (!pq.isEmpty() && pq.peek() <= arr[0]) {
                pq.poll();
            }
            pq.add(arr[1]);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
}