class Solution {
    static int n, answer;
    static int[] ch;
    public void D(int k, int[][] dungeons, int L) {
        
            for (int i = 0; i < dungeons.length; i++) {
                if (ch[i] == 0 && k >= dungeons[i][0]) {
                    ch[i] = 1;
                    D(k - dungeons[i][1], dungeons, L + 1);
                    ch[i] = 0;
                }
            }
            answer = Math.max(answer, L);
        
    }
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        n = dungeons.length;
        ch = new int[n];
        D(k, dungeons, 0);
        return answer;
    }
}