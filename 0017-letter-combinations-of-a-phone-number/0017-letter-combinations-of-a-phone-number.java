// 1. 브루트 포스?
// 2. 
import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();

        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));

        List<String> answer = new ArrayList<>();
        int len = digits.length();
        if (len == 1) {
            return map.get(digits.charAt(0));
        }

        if (len == 2) {
            char x = digits.charAt(0);
            char y = digits.charAt(1);
            List<String> one = map.get(x);
            List<String> two = map.get(y);
            for (int i = 0; i < one.size(); i++) {
                for (int j = 0; j < two.size(); j++) {
                    answer.add(one.get(i)+two.get(j));
                }
            }
            return answer;
        }

        if (len == 3) {
            char x = digits.charAt(0);
            char y = digits.charAt(1);
            char z = digits.charAt(2);
            List<String> one = map.get(x);
            List<String> two = map.get(y);
            List<String> three = map.get(z);
            for (int i = 0; i < one.size(); i++) {
                for (int j = 0; j < two.size(); j++) {
                    for (int k = 0; k < three.size(); k++) {
                        answer.add(one.get(i)+two.get(j)+three.get(k));
                    }
                }
            }
            return answer;
        }

        if (len == 4) {
            char x = digits.charAt(0);
            char y = digits.charAt(1);
            char z = digits.charAt(2);
            char o = digits.charAt(3);
            List<String> one = map.get(x);
            List<String> two = map.get(y);
            List<String> three = map.get(z);
            List<String> four = map.get(o);
            for (int i = 0; i < one.size(); i++) {
                for (int j = 0; j < two.size(); j++) {
                    for (int k = 0; k < three.size(); k++) {
                        for (int w = 0; w < four.size(); w++) {
                            answer.add(one.get(i)+two.get(j)+three.get(k)+four.get(w));
                        }
                    }
                }
            }
            return answer;
        }
        

        return null;
    }
}