package HackerRank;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DesignerPDFViewer {

    static int designerPdfViewer(int[] h, String word) {

        int[] arr = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            arr[i] = h[word.charAt(i)-'a'];
        }

        int a = Collections.max(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        return a*arr.length;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        System.out.println(designerPdfViewer(h, word));

        scanner.close();
    }

}
