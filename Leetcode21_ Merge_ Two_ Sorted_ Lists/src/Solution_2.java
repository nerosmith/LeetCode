public class Solution_2 {

    public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if (l1 == null || l2 == null) return l2 == null ? l1 : l2;
            ListNode root = (l2.val >= l1.val) ? l1 : l2;
            ListNode rootnext = root == l1 ? l2 : l1;
            root.next = mergeTwoLists(root.next,rootnext);
            return root;
        }
}
