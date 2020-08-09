package GeeksForGeeks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-09
 */

//url : https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x/0
class Pair {
    int u, v;
    Pair(int a, int b) {
        u = a;
        v = b;
    }
}

public class FindPairWithGivenSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            t--;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int x = scanner.nextInt();
            HashSet<Integer> a = new HashSet<>();
            ArrayList<Pair> res = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }
            for(int i = 0; i < m; i++) {
                int el = scanner.nextInt();
                if(a.contains(x - el)) {
                    res.add(new Pair(x-el, el));
                }
            }
            if(res.isEmpty()) {
                System.out.println("-1");
                continue;
            }

            res.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.u - o2.u;
                }
            });
            boolean first = true;
            for (Pair re : res) {
                if (!first)
                    System.out.print(", ");
                System.out.print(re.u + " " + re.v);
                first = false;
            }
            System.out.println();
        }
    }

}
