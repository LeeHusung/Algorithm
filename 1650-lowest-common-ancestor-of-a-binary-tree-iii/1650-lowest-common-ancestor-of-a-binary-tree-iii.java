/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
import java.util.*;
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // System.out.println(p.parent);
        // System.out.println(q.parent.val);

        List<Node> list1 = new ArrayList<>();
        list1.add(p);
        while(p.parent != null) {
            list1.add(p.parent);
            p = p.parent;
        }

        List<Node> list2 = new ArrayList<>();
        list2.add(q);
        while(q.parent != null) {
            list2.add(q.parent);
            q = q.parent;
        }
        int maxIdx = Integer.MIN_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).val == list2.get(j).val) {
                    return list1.get(i);
                }
            }
        }
        return p;
    }
}