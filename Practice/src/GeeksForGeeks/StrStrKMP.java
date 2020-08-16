package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-16
 */
// url https://www.youtube.com/watch?v=GTJr8OvyEVQ
public class StrStrKMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String x = sc.next();
        strstr(s, x);
    }

    private static void strstr(String s, String x) {
        int n = s.length();
        int m = x.length();
        int lps[] = new int[m];
        computeLPSArray(lps, x, m);

        int i = 0, j = 0;
        while(i < n) {
            if(s.charAt(i) == x.charAt(j)) {
                i++;
                j++;
            }
            if(j == m) {
                System.out.println(i-j);
                j = lps[j-1];
            }
            else if(i < n && s.charAt(i) != x.charAt(j)) {
                if(j != 0)
                    j = lps[j-1];
                else
                    i = i + 1;
            }
        }
     }

    private static void computeLPSArray(int[] lps, String x, int m) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i < m) {
            if(x.charAt(i) == x.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[i-1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
