import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> convertMap = new HashMap<>();
        Map<String, String> answerMap = new HashMap<>();
        List<String> names = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> convertGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            convertGraph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            String name = st.nextToken();
            names.add(name);
            map.put(name, i);
            convertMap.put(i, name);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            String a = s[0];
            String b = s[1];
            graph.get(map.get(a)).add(map.get(b));
            convertGraph.get(map.get(b)).add(map.get(a));
        }

        int cnt = 0;
        List<Integer> sijos = new ArrayList<>();
        List<String> sijosString = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (graph.get(i).isEmpty()) {
                cnt++;
                sijos.add(i);
            }
        }
        System.out.println(cnt);
        for (Integer sijo : sijos) {
            sijosString.add(convertMap.get(sijo));
        }
        Collections.sort(sijosString);
        for (String s : sijosString) {
            System.out.print(s + " ");
        }
        System.out.println();

        Queue<Integer> q = new ArrayDeque<>();
        int[] indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (convertGraph.get(i).isEmpty()) {
                q.offer(i);
                continue;
            }
            indegree[i] = convertGraph.get(i).size();
        }

        Collections.sort(names);
        int[] ch = new int[n + 1];
        while (!q.isEmpty()) {
            Integer p = q.poll();
            //나오는 순서가 아래부터 꺼내진다.
            if (convertGraph.get(p).isEmpty()) {
                answerMap.put(convertMap.get(p), "0");
            } else {
                int count = 0;
                List<Integer> childs = new ArrayList<>();
                for (int x : convertGraph.get(p)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        count++;
                        childs.add(x);
                    }
                }
                List<String> sortedChilds = new ArrayList<>();
                for (Integer child : childs) {
                    sortedChilds.add(convertMap.get(child));
                }
                Collections.sort(sortedChilds);
                StringBuilder sb = new StringBuilder();
                for (String child : sortedChilds) {
                    sb.append(child).append(" ");
                }
                answerMap.put(convertMap.get(p), count + " " + sb.toString());
            }
            for (Integer x : graph.get(p)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.offer(x);
                }
            }
        }

        for (String name : names) {
            System.out.println(name + " " + answerMap.get(name));
        }
    }
}
