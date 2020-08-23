package Leet;

/**
 * @author ramyalakshmi.s created on 2020-08-23
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    private static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];

        computeLPS(lps, n, s);

        int len = lps[n-1];

        return (len > 0 && n % (n - len) == 0);
    }

    private static void computeLPS(int[] lps, int n, String s) {
        int len = 0;
        int i;

        lps[0] = 0;
        i = 1;

        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
