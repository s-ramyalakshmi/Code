package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-11
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        String prefix = "";
        if(n == 0)
            return prefix;
        int index = findMinLength(arr, n);

        int low = 0, high = index-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(containsPrefix(arr, n, low, mid)) {
                prefix = prefix + arr[0].substring(low, mid+1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return prefix;
    }

    private static boolean containsPrefix(String[] arr, int n, int low, int mid) {

        String a = arr[0];
        for(int i = 0; i <= (n-1); i++) {
            String ar = arr[i];
            for(int j = low; j <= mid; j++) {
                if(ar.charAt(j) != a.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int findMinLength(String[] arr, int n) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= n-1; i++) {
            if(arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return min;
    }

}
