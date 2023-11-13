
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length() - 1;
            for (int j = 0; j < arr[i].length(); j++) {
                int sum = 1;
                for (int k = 0; k < len; k++) {
                    sum *= 10;
                }
                len--;
                map.put(arr[i].charAt(j), map.getOrDefault(arr[i].charAt(j), 0) + sum);
            }
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> map.get(b).compareTo(map.get(a)));

        Map<Character, String> resMap = new HashMap<>();
        String[] str = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0"};
        int idx = 0;
        for (char ch : list) {
            resMap.put(ch, str[idx++]);
        }
        List<String> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String aaa = "";
            for (int j = 0; j < arr[i].length(); j++) {
                String k = resMap.get(arr[i].charAt(j));
                aaa = aaa + k;
            }
            res.add(aaa);
        }

        int answer = 0;
        for (int i = 0; i < res.size(); i++) {
            answer += Integer.parseInt(res.get(i));
        }
        System.out.println(answer);
    }
}
