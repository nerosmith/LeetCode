public class Solution {

    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(0);
            ListNode p = root;

            while (l1 != null && l2 != null){
                    if (l1.val > l2.val){
                            p.next = l2;
                            l2 = l2.next;
                        }
                    else{
                        p.next = l1;
                        l1 = l1.next;
                     }
                }

            if (l1 != null)
                p.next = l1;
            else
                p.next = l2;

            ListNode ret = root.next;
            root.next = null;
            return ret;
        }
}
