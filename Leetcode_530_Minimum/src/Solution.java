import java.util.ArrayList;
import java.util.Stack;

public class Solution {


    private Integer prev = null;
    private int res = Integer.MAX_VALUE;
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

    public int getMinimumDifference(TreeNode root) {
        prev = null;
        return inOder(root);
    }

    private int inOder(TreeNode node){
            if (node == null)
                return res;
            res = Math.min(res,inOder(node.left));
            if (prev != null)
                res = Math.min(res,node.val - prev);
            prev = node.val;
            res = Math.min(res,inOder(node.right));
            return res;
        }
}