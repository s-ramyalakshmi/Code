package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-16
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum(a));
    }

    private static int minPathSum(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int dp[][] = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] = a[i][j];
                else if(i == 0)
                    dp[i][j] = a[i][j] + dp[i][j-1];
                else if(j == 0)
                    dp[i][j] = a[i][j] + dp[i-1][j];
                else
                    dp[i][j] = Math.min(a[i][j] + dp[i-1][j], a[i][j] + dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];
    }
}
