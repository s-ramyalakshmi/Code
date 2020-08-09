package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-07
 */
public class TwoSums {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] ans = twoSum(a, m);
        System.out.println(ans[0] + " " +  ans[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        int sol[] = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }

}
