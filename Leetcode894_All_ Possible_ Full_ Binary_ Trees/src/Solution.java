import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0)
            return res;

        if (N == 1){
                res.add(new TreeNode(0));
                return res;
            }

        for (int i = 1; i < N; i= i+2) {
                List<TreeNode> lns = allPossibleFBT(i);
                List<TreeNode> rns = allPossibleFBT(N-i-1);
                for (TreeNode ln: lns) {
                    for (TreeNode rn : rns){
                        TreeNode head = new TreeNode(0);
                        head.left = ln;
                        head.right = rn;
                        res.add(head);
                    }
                }
            }
        return res;
    }
}
