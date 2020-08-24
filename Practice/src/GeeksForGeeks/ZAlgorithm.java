package GeeksForGeeks;

/**
 * @author ramyalakshmi.s created on 2020-08-24
 */
// z[] --> z[i] is length of substring starting from ith position which is prefix of entire string
public class ZAlgorithm {
    public static void main(String[] args) {
        searchPattern("bbaabaa", "aab");
    }

    private static void searchPattern(String text, String pat) {
        String x = pat+"$"+text;
        int[] z = new int[x.length()];

        zArr(x, z);

        for(int i = 0; i < x.length(); i++) {
            if(z[i] == pat.length())
                System.out.println(i-pat.length());
        }

    }

    private static void zArr(String x, int[] z) {
        int n = x.length();

        int L = 0, R = 0, k;

        for(int i = 1; i < n; i++) {
            if(i > R) {
                L = R = i;
                while(R < n && x.charAt(R-L) == x.charAt(R))
                    R++;
                z[i] = R-L;
                R--;
            } else {
                k = i - L;
                if(z[k] < R - i +1)
                    z[i] = z[k];
                else {
                    L = i;
                    while(R < n && x.charAt(R-L) == x.charAt(R))
                        R++;
                    z[i] = R-L;
                    R--;
                }
            }
        }
    }
}
