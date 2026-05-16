import java.util.*;
class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        List<Tuple> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Tuple tuple = new Tuple(username[i], website[i], timestamp[i]);
            list.add(tuple);
        }

        list.sort((a, b) -> a.getTimestamp() - b.getTimestamp());
        // for (Tuple tuple : list) {
        //     System.out.println(tuple.getUsername() + "    " + tuple.getWebsite() + "    " + tuple.getTimestamp());
        // }
        // System.out.println("=========================");
        Map<String, List<String>> map = new HashMap<>();
        for (Tuple tuple : list) {
            if (!map.containsKey(tuple.getUsername())) {
                map.put(tuple.getUsername(), new ArrayList<>());
                map.get(tuple.getUsername()).add(tuple.getWebsite());
            }
            else {
                map.get(tuple.getUsername()).add(tuple.getWebsite());
            }
        }

        Map<String, Integer> result = new HashMap<>();
        for (String user : map.keySet()) {
            List<String> websites = map.get(user);
            // System.out.println(websites);
            int n = websites.size();
            if (n < 3) continue;
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        String key = websites.get(i) + " " + websites.get(j) + " " + websites.get(k);
                        if (!temp.contains(key)) {
                            temp.add(key);
                        }
                    }
                }
            }
            for (String x : temp) {
                result.putIfAbsent(x, 0);
                result.put(x, result.get(x) + 1);
            }
        }

        List<String> answers = new ArrayList<>();
        int tmp = 0;
        for (String x : result.keySet()) {
            int cnt = result.get(x);
            if (tmp < cnt) {
                answers.clear();
                answers.add(x);
                tmp = cnt;
            }
            else if (tmp == cnt) {
                answers.add(x);
            }
        }
        Collections.sort(answers);
        String answer = answers.get(0);
        // System.out.println(answer);
        String[] answerList = answer.split(" ");
        List<String> a = new ArrayList<>();
        for (String k : answerList) {
            a.add(k);
        }
        return a;

    }

    public class Tuple {
        String username;
        String website;
        int timestamp;

        public Tuple(String username, String website, int timestamp) {
            this.username = username;
            this.website = website;
            this.timestamp = timestamp;
        }

        public String getUsername() {
            return this.username;
        }
        public String getWebsite() {
            return this.website;
        }
        public int getTimestamp() {
            return this.timestamp;
        }
    }
}