package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-08
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for(int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(findMedianSortedArrays(a, b));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int i = 0;
        int j = 0;
        int count;
        double m1 = -1;
        double m2 = -1;
        int n = nums1.length;
        int m = nums2.length;

        if((n + m) % 2 == 1) {

            for(count = 0; count <= (n+m)/2; count++) {
                if(i != n && j != m) {
                    m1 = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
                }
                else if (i < n) {
                    m1 = nums1[i++];
                }
                else {
                    m1 = nums2[j++];
                }
            }
            return m1;

        } else {

            for(count = 0; count <= (n+m)/2; count++) {
                m2 = m1;
                if(i != n && j != m) {
                    m1 = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
                }
                else if (i < n) {
                    m1 = nums1[i++];
                }
                else {
                    m1 = nums2[j++];
                }
            }
            return (m1+m2)/2;

        }

    }

}
