package GeeksForGeeks;

import java.util.*;

/**
 * @author ramyalakshmi.s created on 2020-08-24
 */
public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();

            int[][] board = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++)
                    board[i][j] = 0;
            }
            ArrayList<List<Integer>> res = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            solveNQueens(board, 0, n, res, ans);

            StringBuffer sb = new StringBuffer();
            if(res.size() > 0) {
                for(int i = 0; i < res.size(); i++) {
                    sb.append("[");
                    for(int j = 0; j < res.get(i).size(); j++) {
                        sb.append(res.get(i).get(j)+" ");
                    }
                    sb.append("] ");
                }
            }
            else {
                sb.append("-1");
            }
            System.out.println(sb);
        }
    }

    private static void solveNQueens(int[][] board, int col, int n, ArrayList<List<Integer>> res, ArrayList<Integer> ans) {
        if(col == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSafe(board, i, col, n)) {
                board[i][col] = 1;
                ans.add(i + 1);
                solveNQueens(board, col+1, n, res, ans);
                board[i][col] = 0;
                ans.remove(ans.size()-1);

            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        int i, j;

        for(i = 0; i < col; i++) {
            if(board[row][i] == 1)
                return false;
        }

        //left upper diagonal
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        //left lower diagonal
        for(i = row, j = col; i < n && j >= 0; i++, j--) {
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }
}
