import java.util.*;
class Solution {
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        LinkedList<Integer> list = new LinkedList<>();
        int maxx = -1;
        int maxy = -1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int x = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int y = nums[j];
                if (y < x) {
                    if (j > maxy) {
                        maxy = j;
                        maxx = i;
                        // System.out.println(maxx);
                        // System.out.println(maxy);
                    }
                    flag = true;
                }
            }
        }
        // System.out.println(flag);
        if (maxx < 0) maxx = 0;
        if (maxy < 0) maxy = 0;
        int tmp = nums[maxx];
        nums[maxx] = nums[maxy];
        nums[maxy] = tmp;
        // System.out.println(maxx);
        // System.out.println(maxy);
        LinkedList<Integer> sort = new LinkedList<>();
        for (int k = 0; k < maxy + 1; k++) {
            list.add(nums[k]);
        }
        // System.out.println(list.toString());
        for (int k = maxy + 1; k < nums.length; k++) {
            sort.add(nums[k]);
        }
        Collections.sort(sort);
        for (int z : sort) {
            list.add(z);
        }
        if (!flag) {
            Arrays.sort(nums);
        } else {
            int[] res = new int[list.size()];
            int idx = 0;
            for (int k : list) {
                res[idx++] = k;
            }
            // System.out.println(Arrays.toString(res));
            for (int k = 0; k < res.length; k++) {
                nums[k] = res[k];
            }
        }
    }
}