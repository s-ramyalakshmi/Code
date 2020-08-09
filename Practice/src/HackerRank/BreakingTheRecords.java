package HackerRank;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class BreakingTheRecords {

    static int[] breakingRecords(int[] scores) {

        int mini = 100000001;
        int maxi = -1;
        int maxC = 0;
        int minC = 0;

        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > maxi) {
                maxi = scores[i];
                maxC++;
            }
            if(scores[i] < mini) {
                mini = scores[i];
                minC++;
            }
        }

        int[] result = new int[2];
        result[0] = --maxC;
        result[1] = --minC;
        return  result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int scoresItem = parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
    }

}
