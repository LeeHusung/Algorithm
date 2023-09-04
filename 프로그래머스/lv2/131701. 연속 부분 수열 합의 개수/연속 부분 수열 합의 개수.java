import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        int[] iarr = new int[elements.length * 2];
        
        for (int i = 0; i<elements.length * 2; i++) {
            iarr[i] = elements[i % elements.length];
        }
        
        for (int i = 1; i<= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < i + j; k++) {
                    sum += iarr[k];
                }
                set.add(sum);
            }
        }
        
//         List<Integer> list = new ArrayList<>();
//         for (int i = 0; i<elements.length; i++) {
//             list.add(elements[i]);
//         }
        
//         for (int i = 0; i<elements.length; i++) {
//             list.add(elements[i]);
//         }
        
//         for (int i = 1; i<=list.size(); i++) {
//             for (int j = 0; j<list.size(); j++) {
//                 int sum = 0;
//                 for (int k = j; k < i+j; k++) {
//                     if (k < list.size()) {
//                         sum += list.get(k);
//                     }
//                 }
//                 set.add(sum);
//             }
//         }

        
        
        
        return set.size();
    }
}