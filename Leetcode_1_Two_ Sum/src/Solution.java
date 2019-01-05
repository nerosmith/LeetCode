public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target){
                            int[] ret = {i,j};
                            printVec(ret);
                            return ret;
                        }
                }
            }
        throw new IllegalArgumentException("the input has no solution");
    }

    private void printVec(int[] vec){
            for (int e: vec) {
                    System.out.print(e+" ");
                }
        }

    public static void main(String[] args) {
            int nums[] = {0,4,3,0};
            int target = 7;
            Solution solution = new Solution();
            solution.twoSum(nums,target);
        }
}
