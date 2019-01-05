public class ListNode {

    int val;
    ListNode next;
    ListNode(int x){val = x;}

   //鏈表節點構造函數
   //使用 arr 為參數,創建一個表鏈表,當前的 ListNode 為練表頭節點
   public ListNode(int[] arr){

            if(arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr can not be empty");
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i <arr.length ; i++){
                    cur.next = new ListNode(arr[i]);
                    cur = cur.next;
                }
        }

   //以當前節點的練表信息字符串
   @Override
   public String toString(){
            StringBuffer res = new StringBuffer();
            ListNode cur = this;
            while(cur != null){
                    res.append(cur.val+"->");
                    cur = cur.next;
                }
            res.append("NULL");
            return  res.toString();
        }
}
