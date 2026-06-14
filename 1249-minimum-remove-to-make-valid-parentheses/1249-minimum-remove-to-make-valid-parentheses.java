class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < sb.length(); i++) {
            char x = sb.charAt(i);
            if (x == '(') {
                cnt1++;
            }
            else if (x == ')') {
                cnt2++;
                if (cnt1 == 0 || (cnt2 > cnt1)) {
                    sb.deleteCharAt(i);
                    cnt1 = 0;
                    cnt2 = 0;
                    i--;
                }
            }
        }
        // System.out.println(sb);
        cnt1 = 0;
        cnt2 = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char x = sb.charAt(i);
            if (x == ')') {
                cnt2++;
            }
            else if (x == '(') {
                cnt1++;
                if (cnt2 == 0 || (cnt2 < cnt1)) {
                    sb.deleteCharAt(i);
                    cnt1 = 0;
                    cnt2 = 0;
                    // i++;
                }
            }
        }
        return sb.toString();
    }
}