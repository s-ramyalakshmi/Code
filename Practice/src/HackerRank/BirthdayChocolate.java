package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-06-07
 */
public class BirthdayChocolate {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        List<Integer> s = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            s.add(x);
        }

        int d = scanner.nextInt();

        int m = scanner.nextInt();

        int[] su = s.stream().mapToInt(Integer::intValue).toArray();

        int result = getBirthday(su, su.length, d, m);

        System.out.println(result);


    }

    static int getBirthday(int s[], int n, int d, int m) {

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(i+m <= n && Arrays.stream(s, i, i+m).sum() == d) {
                count++;
            }
        }

        return  count;
    }

}
