public class Solution {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
        }

    public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode cur  = head;
            cur.next = deleteDuplicates(cur.next);
            cur.next = (cur.val == cur.next.val) ? cur.next.next : cur.next;
            return cur;
       }
}
