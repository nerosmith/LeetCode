import java.util.List;

public class Solution {
    class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                    val = x;
                    next = null;
                }
        }
    public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null)
                return false;
            ListNode fast = head.next;
            while(head != fast){
                    if (fast.next == null || fast.next.next == null)
                        return false;
                    fast = fast.next.next;
                    head = head.next;
                }
            return true;
        }
}
