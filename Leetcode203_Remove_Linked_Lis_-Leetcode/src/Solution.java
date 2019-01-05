public class Solution {
     public ListNode removeElements(ListNode head,int val){

           //無虛擬頭節點寫法
            while (head != null && head.val == val){
                        /*ListNode delNode = head;
                        head = head.next;
                        delNode.next = null;一般在寫*/
                        head = head.next;//在 Leetcode 的寫法,因為 Leetcode 自然會處理上述這些東西
                }

            if (head == null)
                return null;

            ListNode prev = head;
            while(prev.next != null){
                    if(prev.next.val == val){
                            /*ListNode delNode = prev.next;
                            prev.next = delNode.next;
                            delNode.next = null;*一般在寫*/
                            prev.next = prev.next.next;//在 Leetcode 的寫法,因為 Leetcode 自然會處理上述這些東西
                        }
                    else
                        prev = prev.next;
                }
            return head;
        }

        public static void main(String[] args){
            int[]  nums = {1,2,3,4,5,6};
            ListNode head =  new ListNode(nums);
            System.out.println(head);

            ListNode res =  (new Solution()).removeElements(head,6);
            System.out.println(res);
        }
}
