class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        
        for (int i = 1; i <= n/2; i++) {
            String str = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int idx = 0;
            for (int j = i; j < n; j+=i) {
                if (i + j > n) {
                    idx = j;
                    break;
                }
                String next = s.substring(j, j + i);
                if (str.equals(next)) count++;
                else {
                    if (count > 1) sb.append(count);
                    sb.append(str);
                    count = 1;
                }
                str = next;
            }
            if (count > 1) sb.append(count);
            sb.append(str);
            if (idx > 0) sb.append(s.substring(idx));
            answer = Math.min(answer, sb.toString().length());
        }
        
        return answer;
    }
}