package GeeksForGeeks;

/**
 * @author ramyalakshmi.s created on 2020-08-11
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode res = mergeTwoLists(l1, l2);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode an = new ListNode(0);
        ListNode res = an;


        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null && l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if(l1 != null && l2 != null && l2.val < l1.val){
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if(l1 != null) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }
        return an.next;
    }

}
