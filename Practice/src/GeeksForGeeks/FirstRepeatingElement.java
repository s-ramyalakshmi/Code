package GeeksForGeeks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-12
 */
public class FirstRepeatingElement {

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
            System.out.println(findFirstRepeatingElement(a, n));
        }
    }

    private static int findFirstRepeatingElement(int[] a, int n) {
        HashSet<Integer> hm = new HashSet<>();
        int an = -1;
        for(int i = n-1; i >=  0; i--) {
            if(hm.contains(a[i])) {
                an = i+1;
            } else {
                hm.add(a[i]);
            }
        }
        return an;
    }

}

