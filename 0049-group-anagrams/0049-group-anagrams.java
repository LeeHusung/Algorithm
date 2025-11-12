import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, String> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        List<String> zeros = new ArrayList<>();
        for (String str : strs) {
            if (str.equals("")) {
                zeros.add("");
                continue;
            }
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            map.put(tmp, map.getOrDefault(tmp, "") + str + " ");
        }
        for (String key : map.keySet()) {
            String str = map.get(key);
            String[] split = str.split(" ");
            List<String> tmp = new ArrayList<>();
            for (String s : split) {
                tmp.add(s);
            }
            answer.add(tmp);
        }
        if (!zeros.isEmpty()) {
            answer.add(zeros);
        }
        return answer;
    }
}