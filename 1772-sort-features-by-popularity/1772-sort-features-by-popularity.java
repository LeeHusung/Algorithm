import java.util.*;
class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (String feature : features) {
            map.put(feature, 0);
        }

        Set<String> set = new HashSet<>();
        for (String response : responses) {
            String[] splits = response.split(" ");
            for (String str : splits) {
                set.add(str);
            }
            for (String str : set) {
                if (map.containsKey(str)) {
                    map.put(str, map.getOrDefault(str, 0) + 1);
                }
            }
            set.clear();
        }

        Arrays.sort(features, (a, b) -> map.get(b) - map.get(a));
        return features;
    }
}