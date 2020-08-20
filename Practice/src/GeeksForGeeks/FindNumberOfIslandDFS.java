package GeeksForGeeks;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ramyalakshmi.s created on 2020-08-18
 */
public class FindNumberOfIslandDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.println(countIsland(a, n, m));
        }
    }

    private static int countIsland(int[][] a, int n, int m) {
        boolean[][] visited = new boolean[n][m];

        int count  = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(a[i][j] == 1 && !visited[i][j]) {
                    dfs(a, i, j, visited, n, m);
                    count += 1;
                }

            }
        }
        return count;
    }

    private static void dfs(int[][] a, int i, int j, boolean[][] visited, int n, int m) {

        // 8 adjacent cells
        int[] row = new int[] {0, 0, 1, 1, 1, -1, -1, -1};
        int[] col = new int[] {1, -1, 1, -1, 0, 1, -1, 0};

        visited[i][j] = true;

        for(int k = 0; k < 8; k++) {
            if(isSafe(row[k]+i, col[k]+j, a, visited, n, m))
                dfs(a, row[k]+i, col[k]+j, visited, n, m);
        }

    }

    private static boolean isSafe(int row, int col, int[][] a, boolean[][] visited, int n, int m) {
        return (row >= 0 && row < n && col >= 0 && col < m && a[row][col] == 1 && !visited[row][col]);
    }
}
