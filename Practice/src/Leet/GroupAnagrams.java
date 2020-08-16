package Leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-16
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for(int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        List<List<String>> res = groupAnagrams(s);
        for (List<String> a: res) {
            System.out.println(a);
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> hm = new HashMap<>();

        for (int j = 0; j < strs.length; j++) {
            HashMap<Character, Integer> hash = new HashMap<>();
            String str = strs[j];

            for(int i = 0; i < str.length(); i++) {
                if(hash.containsKey(str.charAt(i)))
                    hash.put(str.charAt(i), hash.get(str.charAt(i)) + 1);
                else
                    hash.put(str.charAt(i), 1);
            }

            if(hm.containsKey(hash))
                hm.get(hash).add(str);
            else {
                ArrayList an = new ArrayList<String>();
                an.add(str);
                hm.put(hash, an);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(HashMap<Character, Integer> h: hm.keySet())
            res.add(hm.get(h));
        return res;
    }
}
