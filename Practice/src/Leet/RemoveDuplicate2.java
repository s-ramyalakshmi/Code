package Leet;

/**
 * @author ramyalakshmi.s created on 2020-08-22
 */
public class RemoveDuplicate2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, null)))))));
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, null)))));
        ListNode res = deleteDuplicates(head);
        while(res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0, null);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while(curr != null) {

            while(curr.next != null && prev.next.val == curr.next.val)
                curr = curr.next;

            if(prev.next == curr) {
                prev = prev.next;
            }
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
