package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-13
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(removeDuplicate(a));
    }

    private static int removeDuplicate(int[] a) {
        int n = a.length;
        if(n == 0 || n == 1)
            return n;
        int j = 0;
        for(int i = 0; i < n-1; i++) {
            if(a[i] != a[i+1]) {
                a[j++] = a[i];
            }
        }
        a[j++] = a[n-1];
        return j;
    }
}
