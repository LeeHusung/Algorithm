class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length;
        int[] arr = new int[n];
        int[] answer = new int[len];
        int index = 0;
        int cnt = 0;
        for (int[] query : queries) {
            int idx = query[0];
            int num = query[1];
            int tmp = 0;
            int tmp2 = 0;
                if (idx - 1 >= 0 && arr[idx - 1] != 0 && arr[idx - 1] == arr[idx]) {
                    tmp++;
                }
                if (idx + 1 < n && arr[idx + 1] != 0 && arr[idx] == arr[idx + 1]) {
                    tmp++;
                }
                arr[idx] = num;
                if (idx - 1 >= 0 && arr[idx - 1] != 0 && arr[idx - 1] == arr[idx]) {
                    tmp2++;
                }
                if (idx + 1 < n && arr[idx + 1] != 0 && arr[idx] == arr[idx + 1]) {
                    tmp2++;
                }
                // System.out.println("tmp: " + tmp + ", tmp2: " + tmp2);
                int sum = tmp2 - tmp;
                cnt += sum;
                // System.out.println("sum: " + sum + ", cnt: " + cnt);
                answer[index++] = cnt;
        }



        return answer;
    }
}