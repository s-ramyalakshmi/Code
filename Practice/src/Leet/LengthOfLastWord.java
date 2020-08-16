package Leet;

import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-16
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.trim();
        System.out.println(s.substring(s.lastIndexOf(" ") + 1).length());

    }
}
