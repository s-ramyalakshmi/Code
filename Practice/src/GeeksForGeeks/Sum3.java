package GeeksForGeeks;

import java.util.*;

/**
 * @author ramyalakshmi.s created on 2020-08-11
 */
public class Sum3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        List<List<Integer>> res = findSumOfTriplet(a);
        for (List<Integer> ab: res) {
            System.out.println(ab);

        }
    }

    private static List<List<Integer>> findSumOfTriplet(int[] a) {
        Arrays.sort(a);
        Set<List<Integer>> an = new HashSet<>();
        int k = a.length - 1;

        for(int i = 0; i < a.length-2; i++) {
            int j = i+1;
            k = a.length-1;
            while(j < k) {
                int sum = a[j]+a[k];
                if(sum == -a[i]) {
                    an.add(Arrays.asList(a[i], a[j], a[k]));
                    j++;
                    k--;
                } else if(sum < -a[i]) {
                    j++;
                } else if(sum > -a[i]) {
                    k--;
                }
            }
        }
        return new ArrayList<>(an);
    }
}
