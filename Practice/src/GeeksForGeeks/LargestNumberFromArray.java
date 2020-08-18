package GeeksForGeeks;

import java.util.*;

/**
 * @author ramyalakshmi.s created on 2020-08-18
 */
public class LargestNumberFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Vector<String> a = new Vector<>();
            for(int i = 0; i < n; i++)
                a.add(sc.next());
            System.out.println(findLargestNumber(a, n));
        }
    }

    private static String findLargestNumber(Vector<String> a, int n) {
        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ab.compareTo(ba) > 0 ? -1 : 1;
            }
        });
        Iterator it = a.iterator();
        String res = "";
        while(it.hasNext()) {
            res += it.next();
        }
        return res;
    }
}
