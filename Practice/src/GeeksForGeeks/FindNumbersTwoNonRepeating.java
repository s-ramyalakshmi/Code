package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-15
 */

// video : https://www.youtube.com/watch?v=QZzH7ZTksKk
public class FindNumbersTwoNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0) {
            t--;
            int n = sc.nextInt();
            n = 2*n + 2;
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            findTwoNonRepeatingNumbers(a, n);
        }
    }

    private static void findTwoNonRepeatingNumbers(int[] a, int n) {
        int xor = a[0];

        for(int i = 1; i < n; i++)
            xor = xor ^ a[i];

        //-xor -> ~(xor+1)
        int setBit = xor & -xor;
        int x = 0, y = 0;
        for(int i = 0; i < n; i++) {
            int an = setBit & a[i];
            if(an == 0) {
                x = x ^ a[i];
            }
            else {
                y = y ^ a[i];
            }
        }
        int res1 = -1, res2 = -1;
        if(x <= y) {
            res1 = x;
            res2 = y;
        }
        else {
            res1 = y;
            res2 = x;
        }
        System.out.println(res1 + " " + res2);
    }
}
