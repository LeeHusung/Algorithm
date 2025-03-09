class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            }
        }

        int pairs = 0;
        for (int value : cntMap.values()) {
            pairs += value / 2;
        }

        int answer = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String str : words) {
            int need = str.length() / 2;
            if (pairs >= need) {
                answer++;
                pairs -= need;
            }
        }
        return answer;
    }
}