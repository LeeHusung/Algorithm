
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String s : skill_trees) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<s.length(); i++) {
                String str = String.valueOf(s.charAt(i));
                if (skill.contains(str)) {
                    sb.append(str);
                }
            } //일치하는 skill들 sb에 모두 담기
            
            boolean flag = true;
            for (int i = 0; i<sb.length(); i++) {
                if (skill.charAt(i) != sb.toString().charAt(i)) { //순서 다르면 모두 반복 종료
                    flag = false; // flag는 갯수 세기 용도
                    break;
                }
            }
            if (flag) {
                answer += 1;
            }
        }
       
        return answer;
    }
}
        
//         // q에 순서대로 넣고 skill_trees도 순서대로 다 넣고 하나씩 빼면서 순서 같으면 ok
        
//         Queue<Character> skillQ = new LinkedList<>();
        
//         for (int i = 0; i<skill.length(); i++) {
//             skillQ.add(skill.charAt(i));
//         }
        
//         for (int i = 0; i<skill_trees.length; i++) {
//             Queue<Character> treesQ = new LinkedList<>();
//             for (int j = 0; j<skill_trees[i].length(); j++) {
//                 treesQ.add(skill_trees[i].charAt(j));
//                 if (treesQ.peek() != skillQ.peek()) {
//                     if (!skillQ.contains(treesQ.peek())) continue;
//                     else {break;}
//                 } else {
//                     skillQ.poll();
//                     treesQ.poll();
//                     continue;
//                 }
                
//             }
//             if (!treesQ.isEmpty()){
//                 answer++;
//             }   
//         }   
//         return answer;
//     }
// }
