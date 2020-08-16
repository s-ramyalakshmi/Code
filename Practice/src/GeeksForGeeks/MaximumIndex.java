package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-14
 */
public class MaximumIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            t--;
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(findMaximumIndex(a, n));
        }
    }

    private static int findMaximumIndex(int[] a, int n) {
        if(n==1)
            return 0;

        int[] LMin = new int[n];
        int[] RMax = new int[n];

        LMin[0] = a[0];
        //To store minimum value from a[0] to a[n-1]
        for(int i = 1; i < n; i++) {
            LMin[i] = Math.min(LMin[i-1], a[i]);
        }

        //To store maximum value from a[0] to a[n-1]
        RMax[n-1] = a[n-1];
        for(int j = n - 2; j >= 0; j--) {
            RMax[j] = Math.max(a[j], RMax[j+1]);
        }

        int i = 0, j = 0, maxIndex = -1;
        while(j < n && i < n) {
            if(LMin[i] < RMax[j]) {
                maxIndex = Math.max(maxIndex, j-i);
                j = j + 1;
            }
            else
                i = i + 1;
        }
        return maxIndex;
    }
}
