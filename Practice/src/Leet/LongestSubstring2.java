package Leet;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-08
 */

// Sliding window with O(n) using extra space to store last index of character [to make the sub string unique]

// url : https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstring2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(s));


    }
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();

        int i = 0;
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);

        for(int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[s.charAt(j)]+1);
            res = Math.max(res, j - i + 1);
            lastIndex[s.charAt(j)] = j;
        }

        return res;
    }

}
