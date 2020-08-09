package Leet;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-08
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();

        if(n < 1)
            return "";

        boolean dp[][] = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = false;
            }
        }

        int length = 1;
        for(int i = 0; i < n; i++)
            dp[i][i] = true;

        int start = 0;
        for(int i = 0; i < n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }

        for(int k = 3; k <= n; k++) {
            for(int i = 0; i < n - k + 1; i++) {

                int j = i + k - 1;

                if(dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;

                    if(k > length) {
                        start = i;
                        length = k;
                    }
                }

            }
        }

        return s.substring(start, start + length);

    }

}
