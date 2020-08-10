package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-10
 */

//dynamic programming

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();

            System.out.println(getLongestCommonSubsequence(s1, s2, n, m));
            t--;
        }
    }

    private static int getLongestCommonSubsequence(String s1, String s2, int n, int m) {
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }

}
