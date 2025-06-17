class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        // System.out.println(str);
        int idx = 0;
            StringBuilder sb = new StringBuilder();
    
        while (true) {
            while (idx < str.length() && str.charAt(idx) != '0') {
                sb.append(str.charAt(idx));
                idx++;
            }
            // System.out.println(idx);
            if (sb.length() > 0 && checkPrime(sb.toString())) {
                answer++;
            }
            sb = new StringBuilder();
            idx++;
            if (idx >= str.length()) break;
        }
        return answer;
    }
    
    private boolean checkPrime(String str) {
        // System.out.println("str: " + str);
        long num = Long.parseLong(str);
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}