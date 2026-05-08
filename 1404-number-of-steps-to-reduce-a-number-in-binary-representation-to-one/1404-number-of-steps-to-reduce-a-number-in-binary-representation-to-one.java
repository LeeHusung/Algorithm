class Solution {
    public int numSteps(String s) {
        if (s.equals("1")) {
            return 0;
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        while (!sb.toString().equals("1")) {
            // System.out.println("real sb: " + sb);
            cnt++;
            if (sb.charAt(sb.length() - 1) == '0') {
                // System.out.println("before: " + sb);
                sb.deleteCharAt(sb.length() - 1);
                // System.out.println("after: " + sb);
            } else {
                boolean flag = false;
                for (int i = sb.length() - 1; i >= 0; i--) {
                    if (sb.charAt(i) == '0') {
                        sb.replace(i, i + 1, "1");
                        // System.out.println("sb1: " + sb);
                        for (int j = i + 1; j < sb.length(); j++) {
                            sb.replace(j, j + 1, "0");
                        }
                        // System.out.println("sb2: " + sb);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    // System.out.println("1: " + sb);
                    sb.insert(0, "1");
                    // System.out.println("2: " + sb);
                    for (int i = 1; i < sb.length(); i++) {
                        sb.replace(i, i + 1, "0");
                    }
                    // System.out.println("3: " + sb);
                }
                // System.out.println("sb3: " + sb);
            }
            // System.out.println("sb: " + sb);
        }


        return cnt;
    }
}