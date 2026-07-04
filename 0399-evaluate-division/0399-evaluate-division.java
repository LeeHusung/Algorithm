import java.util.*;
class Solution {
    Map<String, ArrayList<Edge>> graph = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(a).add(new Edge(b, values[i]));
            graph.get(b).add(new Edge(a, 1.0 / values[i]));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            // System.out.println("c: " + c + ", d: " +d);
            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                result[i] = -1;
                continue;
            }
            if (c.equals(d)) {
                result[i] = 1.0;
                continue;
            }
            Queue<Edge> q = new ArrayDeque<>();
            Set<String> set = new HashSet<>();
            q.offer(new Edge(c, 1.0));
            set.add(c);
            boolean flag = false;
            while(!q.isEmpty()) {
                Edge p = q.poll();
                List<Edge> list = graph.get(p.str);
                for (int j = 0; j < list.size(); j++) {
                    Edge edge = list.get(j);
                    String tmp = edge.str;
                    double val = edge.value;
                    if (tmp.equals(d)) {
                        result[i] = p.value * val;
                        flag = true;
                        break;
                    }
                    if (!set.contains(tmp)) {
                        q.offer(new Edge(tmp, val * p.value));
                        set.add(tmp);
                    }
                }
                if (flag) break;
            }
            if (!flag) {
                result[i] = -1;
            }

        }

        return result;
    }

    public static class Edge {
        String str;
        double value;
        public Edge (String str, double value) {
            this.str = str;
            this.value = value;
        }
    }
}