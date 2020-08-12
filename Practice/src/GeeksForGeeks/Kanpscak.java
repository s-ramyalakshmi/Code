package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-12
 */
public class Kanpscak {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            t--;
            int n = scanner.nextInt();
            int w = scanner.nextInt();
            int[] val = new int[n];
            int[] wt = new int[n];
            for(int i = 0; i < n; i++) {
                val[i] = scanner.nextInt();
            }
            for(int i = 0; i < n; i++) {
                wt[i] = scanner.nextInt();
            }
            System.out.println(knapsack(w, wt, val, n));
        }
    }

    private static int knapsack(int w, int[] wt, int[] val, int n) {
        int i, j;
        int dp[][] = new int[n+1][w+1];

        for(i = 0; i <= n; i++) {
            for(j = 0; j <= w; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(wt[i-1] <= j)
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
    }

}


