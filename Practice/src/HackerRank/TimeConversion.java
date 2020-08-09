//https://www.hackerrank.com/challenges/time-conversion/problem

package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        System.out.println(timeConversion(s));

    }

    private static String timeConversion(String s) {

        String last = s.substring(s.length()-2);
        Integer first = Integer.parseInt(s.substring(0, 2));

        if(last.equals("PM") && first < 12) {
            return (Integer.toString(first+12)+s.substring(2, s.length()-2));
        }
        else if(last.equals("AM") && first == 12) {
            return ("00"+s.substring(2, s.length()-2));
        }
        else {
            return (s.substring(0, s.length()-2));
        }

    }
}
