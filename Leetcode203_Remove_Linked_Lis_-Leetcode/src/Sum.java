public class Sum {

    public static int sum(int[] arr){
            return sum(arr,0);
        }

    //計算arr{l ... n}這個區間所有數字和
    private static int sum(int[] arr,int l){
            if(l == arr.length)
                return 0;
            /*
            * int x = sum(arr,l+1);
            * return res;
            * int res = arr[l] + x;
            *第一種寫法
            * */
            return arr[l] + sum(arr,l+1);
        }

    public static void main(String[] args){
            int[]  nums = {1,2,3,4,5,6,7,8};
            System.out.println(sum(nums));
        }
}
