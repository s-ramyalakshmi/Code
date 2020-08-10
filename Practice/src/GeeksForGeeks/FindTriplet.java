package GeeksForGeeks;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-10
 */
public class FindTriplet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }


        System.out.println(findTriplet(a, n));
    }

    private static boolean findTriplet(int[] a, int n) {

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                int x = -1 * (a[i] + a[j]);
                if(hs.contains(x) && x != a[i] && x != a[j]) {
                    return true;
                }
                else {
                    hs.add(a[j]);
                }
            }
        }
        return false;
    }

}
