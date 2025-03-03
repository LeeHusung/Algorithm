class Solution {
    static int[] answer, tmp, ch;
    private void D(int start, int n, int k) {
        //수열 만들기
        if (start == n) {
            if (check(tmp, k)) {
                return;
            };
            // for (int z : tmp) {
            //     System.out.print(z + " ");
            // }
            // System.out.println();
            return;
        }
        for (int i = 0; i< n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                tmp[start] = i + 1;
                D(start + 1, n, k);
                ch[i] = 0;
            }
        }
    }

    private boolean check(int[] temp, int k) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < temp.length - 1; i++) {
            int t = Math.abs(temp[i] - temp[i + 1]);
            set.add(t);
        }
        if (set.size() == k) {
            answer = temp.clone();
            return true;
        }
        return false;
    }

    public int[] constructArray(int n, int k) {
        answer = new int[n];
        tmp = new int[n];
        ch = new int[n];
        D(0, n, k);
        return answer;
    }
}