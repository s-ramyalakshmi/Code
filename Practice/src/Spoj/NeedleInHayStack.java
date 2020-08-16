package Spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-16
 */
public class NeedleInHayStack {
    public static void main(String[] args) {
//        String s;
//        Scanner sc=new Scanner (System.in);
//        int l;
//        while(sc.hasNext()){
//            l=sc.nextInt();
//            s=sc.next();
//            String x=sc.next();
//            int t=x.indexOf(s,0);
//            if(t==-1) System.out.println();
//            while(t!=-1){
//                System.out.println(t);
//                t=x.indexOf(s,t+1);
//            }
//        }
        Scanner sc = new Scanner(System.in);
        while(sc.nextLine() != null){
            String x = sc.next();
            String s = sc.next();
            findSubString(s, x);
        }
    }

    private static void findSubString(String s, String x) {
        int n = s.length();
        int m = x.length();

        int[] lps = new int[m];
        computeLpsArray(lps, x, m);

        int i = 0, j = 0;
        while(i < n) {
            if(s.charAt(i) == x.charAt(j)) {
                i++;
                j++;
            }
            if(j == m) {
                System.out.println(i-j);
                j = lps[j-1];
            }
            else if(i < n && s.charAt(i) != x.charAt(j)){
                if(j != 0)
                    j = lps[j-1];
                else
                    i = i + 1;
            }
        }
    }

    private static void computeLpsArray(int[] lps, String x, int m) {
        int i = 1, len = 0;
        lps[0] = 0;
        while(i < m) {
            if(x.charAt(i) == x.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0)
                    len = lps[i-1];
                else {
                    lps[i] = len;
                    i = i + 1;
                }
            }
        }
    }
}
