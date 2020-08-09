package HackerRank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StrongPassword {

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        List<Character> c = Arrays.asList('!','@','#','$','%','^','&','*','(',')','-','+');

        int lower = 0, upper = 0, digit = 0, special = 0;

        for(int i = 0 ; i < n; i++) {
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                lower++;
            if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                upper++;
            if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
                digit++;
            if(c.contains(password.charAt(i)))
                special++;
        }

        int ans = 0;

        if(lower == 0)
            ans++;
        if(upper == 0)
            ans++;
        if(digit == 0)
            ans++;
        if(special == 0)
            ans++;

        if(ans > 0)
            if(ans+password.length() < 6)
                return 6 - (ans+password.length()) + ans;

        return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(answer);

        scanner.close();
    }

}
