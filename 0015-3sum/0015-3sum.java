import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); 
                    list.add(nums[l]);
                    list.add(nums[r]);
                    Collections.sort(list);
                    answer.add(list);
                    l++;
                    r--;
                }
                else if (sum < 0) l++;
                else r--;
            }
        }
        List<List<Integer>> answer22 = new ArrayList<>();
        for (List<Integer> tmp : answer) {
            answer22.add(tmp);
        }
        return answer22;
    }
}