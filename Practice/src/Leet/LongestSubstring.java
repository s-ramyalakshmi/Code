package Leet;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-08
 */

// Sliding window method O(n2)

// url : https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(s));


    }
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        //abcabcbb
        for(int i = 0; i < n; i++) {
            boolean visited[] = new boolean[256];
            Arrays.fill(visited, false);
            for(int j = i; j < n; j++) {
                char letter = s.charAt(j);
                if(visited[letter])
                    break;
                else {
                    res = Math.max(res, j - i + 1);
                    visited[letter] = true;
                }
            }
            visited[s.charAt(i)] = false;
        }

        return res;
    }
}
