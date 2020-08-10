package GeeksForGeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-10
 */
public class KadaneAlgorithm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];

            String line = br.readLine();
            int i = 0;
            for (String numStr: line.split("\\s")){
                a[i] = Integer.parseInt(numStr);
                i++;
            }
            System.out.println(getLargestSumContiguous(n, a));
        }
    }

    private static int getLargestSumContiguous(int n, int[] a) {
        int maxim = a[0];
        int sum = a[0];
        for(int i = 1; i < n; i++) {
            sum = Math.max(a[i], a[i]+sum);
            if(maxim < sum)
                maxim = sum;
        }
        return maxim;
    }

}
