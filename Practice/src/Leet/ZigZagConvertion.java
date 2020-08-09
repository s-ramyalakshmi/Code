package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-08
 */

//url : https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConvertion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter s : ");
        String s = scanner.nextLine();
        System.out.println("Enter n : ");
        int k = scanner.nextInt();
        System.out.println(convert(s, k));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        String res = "";

        for(int i = 0; i < s.length(); i += (numRows-1)*2) {
            res += s.charAt(i);
        }

        for(int j = 1; j < numRows-1; j++) {
            boolean down = true;
            for(int i = j; i < s.length();) {
                res += s.charAt(i);
                if(down) {
                    i += (numRows - j - 1) * 2;
                }
                else {
                    i += (numRows - 1) * 2 - (numRows - j - 1) * 2;
                }
                down = !down;
            }
        }

        for(int i = numRows - 1; i < s.length(); i += (numRows - 1)* 2) {
            res += s.charAt(i);

        }

        return res;
    }

}
