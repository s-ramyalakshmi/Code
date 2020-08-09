package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-07
 */

//url : https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();

        int[] num = new int[3];
        num[0] = 1;
        num[1] = 2;
        num[2] = 3;
        ListNode l1;
        ListNode a;
        for(int i = 0; i < 3; i++) {
//            int num = scanner.nextInt();
            a = new ListNode(num[i], null);
            l1 = a;
            l1 = l1.next;
         }

        ListNode l2;
        for(int i = 0; i < 3; i++) {
//            int num = scanner.nextInt();
            l2 = new ListNode(num[i], null);
            l2 = l2.next;
        }

        //System.out.println(addTwoNumbers(l1, l2));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode sum = null;
        int num1 = 0;
        while(l1 != null) {
            num1 = (num1*10) + l1.val;
            num1 *= 10;
            l1 = l1.next;
        }


        return sum;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
