import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxq = new ArrayDeque<>();
        Deque<Integer> minq = new ArrayDeque<>();      
        int left = 0;
        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxq.isEmpty() && nums[maxq.peekLast()] < nums[right]) {
                maxq.pollLast();
            }
            
            while (!minq.isEmpty() && nums[minq.peekLast()] > nums[right]) {
                minq.pollLast();
            }

            maxq.offerLast(right);
            minq.offerLast(right);

            while (nums[maxq.peekFirst()] - nums[minq.peekFirst()] > limit) {
                if (maxq.peekFirst() == left) {
                    maxq.pollFirst();
                }
                if (minq.peekFirst() == left) {
                    minq.pollFirst();
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}