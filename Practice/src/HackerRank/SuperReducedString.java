package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

public class SuperReducedString {

    public static void main(String[] args) throws IOException {

        InputStream in;
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String s = buff.readLine();

        String result = superReducedString(s);

        System.out.println(result);

    }

    private static String superReducedString(String s) {

        for (int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == s.charAt(i-1)) {
                s = s.substring(0, i-1)+s.substring(i+1);
                i = 0;
            }

        }

        return  s.isEmpty() ? "Empty String" : s;


    }

}
