import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        int[] xCounts = new int[10];
        int[] yCounts = new int[10];

        for (char digit : X.toCharArray()) {
            xCounts[digit - '0']++;
        }

        for (char digit : Y.toCharArray()) {
            yCounts[digit - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(xCounts[i], yCounts[i]);
            for (int j = 0; j < commonCount; j++) {
                answer.append(i);
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}


        
//         StringBuilder sb = new StringBuilder();
//         StringBuilder sb2 = new StringBuilder();
//         List<String> answerList = new ArrayList<>();
        
//         for (int i = 0; i<X.length(); i++) {
//             sb.append(X.charAt(i));
//         }
//         for (int i = 0; i<Y.length(); i++) {
//             sb2.append(Y.charAt(i));
//         }
        
//         for (int i = 0; i<sb.length(); i++) {
//             for (int j = 0; j<sb2.length(); j++) {
//                 if (sb.charAt(i) == sb2.charAt(j)){
//                     answerList.add(String.valueOf(sb.charAt(i)));
//                     sb.delete(i, i+1);
//                     sb2.delete(j, j+1);
//                     i--; break;
//                 } else {continue;}
//             }
//         }
        
//         if (answerList.size() == 0) {
//             return "-1";
//         }
//         Collections.sort(answerList, Collections.reverseOrder());
        
//         for (int i = 0; i<answerList.size(); i++) {
//             if (answerList.get(0).equals("0")) return "0";
//             else {
//                 answer += answerList.get(i);
//             }
//         }
//         // Arrays.sort(answer);
//         return answer;
//     }
// }