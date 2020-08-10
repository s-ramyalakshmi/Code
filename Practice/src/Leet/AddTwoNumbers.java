package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-07
 */

//url : https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4,null)));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);
        ListNode res = ans;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            res.next = new ListNode(sum % 10);
            res = res.next;

            if(l1 != null)
                l1 = l1.next;

            if(l2 != null)
                l2 = l2.next;

        }

        if(carry > 0) {
            res.next = new ListNode(carry);
        }

        return ans.next;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
