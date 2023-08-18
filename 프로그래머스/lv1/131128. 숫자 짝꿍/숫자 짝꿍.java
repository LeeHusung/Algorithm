class Solution {
    public String solution(String X, String Y) {
        // 숫자의 등장 횟수를 저장할 배열
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        // 숫자 X의 등장 횟수 계산
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }

        // 숫자 Y의 등장 횟수 계산
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }

        // 결과 문자열을 구성할 StringBuilder 생성
        StringBuilder answer = new StringBuilder();

        // 공통으로 나타나는 숫자 중에서 가장 큰 숫자를 찾아 결과 문자열에 추가
        for (int i = 9; i >= 0; i--) {
            int commonCount = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < commonCount; j++) {
                answer.append(i);
            }
        }

        // 결과 문자열에 아무런 숫자가 추가되지 않았다면 공통으로 나타나는 숫자가 없음
        if (answer.length() == 0) {
            return "-1";
        }

        // 결과 문자열의 첫 번째 숫자가 0이라면, 0으로만 구성되어 있는 경우
        if (answer.charAt(0) == '0') {
            return "0";
        }

        // 결과 문자열 반환
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
