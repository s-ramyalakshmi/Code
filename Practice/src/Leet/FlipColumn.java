package Leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ramyalakshmi.s created on 2020-08-22
 */
public class FlipColumn {
    public static void main(String[] args) {
        int a[][] = new int[][]{{0, 1}, {1, 1}};
        System.out.println(maxEqualRowsAfterFlips(a));
        a = new int[][]{{0, 1}, {1, 0}};
        System.out.println(maxEqualRowsAfterFlips(a));
        a = new int[][]{{0, 0, 0}, {0, 0 ,1}, {1, 1, 0}};
        System.out.println(maxEqualRowsAfterFlips(a));
    }

    private static int maxEqualRowsAfterFlips(int[][] a) {
        int count  = 0;

        HashMap<String, Integer> sameRows = new HashMap<>();
        for(int[] row : a) {
            int ele = row[0];
            String str = "";
            for(int i = 0; i < row.length; i++) {
                if(row[i] == ele)
                    str += "1";
                else
                    str += "0";
            }
            if(sameRows.containsKey(str))
                sameRows.replace(str, sameRows.get(str)+1);
            else
                sameRows.put(str, 1);
        }

        for(String s : sameRows.keySet()) {
            if(count < sameRows.get(s))
                count = sameRows.get(s);
        }
        return count;
    }
}
