public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode pt1 = head;
        ListNode pt2 = head;
        while(pt2 != null && pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next.next;
            
            if(pt1 == pt2)
                return true;
        }
        return false;
    }
}