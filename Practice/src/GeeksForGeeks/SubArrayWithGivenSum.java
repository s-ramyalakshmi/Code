package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-09
 */
//url : https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            t--;
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            findSubArray(a, s);
        }
    }

    private static void findSubArray(long[] a, int s) {
        int n = a.length;
        int start = 0;
        int i;
        long curr_sum = a[0];

        for(i = 1; i <= n; i++) {

            while(curr_sum > s && start < i - 1) {
                curr_sum -= a[start];
                start++;
            }

            if(curr_sum == s) {
                System.out.println((start+1)+" "+(i));
                return;
            }
            if(i < n) {
                curr_sum += a[i];
            }
        }
        System.out.println("-1");
    }

}
