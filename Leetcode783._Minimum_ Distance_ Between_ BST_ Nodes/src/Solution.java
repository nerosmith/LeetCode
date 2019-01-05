import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> list;
    private int num;
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        list.add(root.val);
        dfs(root);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }


}

