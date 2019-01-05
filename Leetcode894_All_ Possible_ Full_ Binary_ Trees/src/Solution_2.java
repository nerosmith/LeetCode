import java.util.ArrayList;
import java.util.List;

public class Solution_2 {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x;}
        }


    public List<TreeNode> allPossibleFBT(int N){
            List<TreeNode> res = new ArrayList<>();
            int[] Array = new int[N];
;            if (N == 1) {
                res.add(new TreeNode(0));
                return res;
            }

            for (int i = 3; i < N; i= i+2){
                    for(int j = 1; j <= i - 1; j += 2){

                        }
                }

        }
}
