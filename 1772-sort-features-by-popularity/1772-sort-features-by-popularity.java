import java.util.*;
class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        int cnt = 0;
        for (String feature : features) {
            map.put(feature, 0);
            count.put(feature, cnt++);
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

        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s2) == map.get(s1)) {
                    return count.get(s1).compareTo(count.get(s2));
                } else {
                    return map.get(s2).compareTo(map.get(s1));
                }
            }
        });

        String[] res = new String[features.length];
        int idx = 0;
        for (String key : keys) {
            res[idx++] = key;
        }
        return res;

    }
}