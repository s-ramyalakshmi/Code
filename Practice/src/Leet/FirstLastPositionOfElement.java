package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-13
 */
public class FirstLastPositionOfElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] res = searchRange(a, t);
        System.out.println(res[0] + " " + res[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, nums.length, target, 0, nums.length-1);
        int last = findLast(nums, nums.length, target, 0, nums.length-1);
        int res[] = new int[2];
        res[0] = first;
        res[1] = last;

        return res;
    }
    public static int findFirst(int[] a, int n, int t, int low, int high) {
        if(high >= low) {
            int mid = (low + high) / 2;
            if((mid == 0 || t > a[mid-1]) && a[mid] == t)
                return mid;
            else if(t <= a[mid])
                return findFirst(a, n, t, low, mid-1);
            else
                return  findFirst(a, n, t, mid+1, high);
        }
        return -1;
    }
    public static int findLast(int[] a, int n, int t, int low, int high) {
        if(high >= low) {
            int mid = (low + high) / 2;
            if((mid == n-1 || t < a[mid+1]) && a[mid] == t)
                return mid;
            else if(t < a[mid])
                return findLast(a, n, t, low, mid-1);
            else
                return  findLast(a, n, t, mid+1, high);
        }
        return -1;
    }
}
