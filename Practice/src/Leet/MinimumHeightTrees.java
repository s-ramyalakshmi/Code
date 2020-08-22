package Leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ramyalakshmi.s created on 2020-08-22
 */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int a[][] = new int[][] {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> res = findMinHeightTrees(4, a);

        a = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}, {5, 6}, {3, 7}, {7, 8}, {2, 9}, {9, 10}};
        res = findMinHeightTrees(11, a);
    }

    private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 0)
            return res;

        if(n == 1 && edges.length == 0) {
            res.add(0);
            return res;
        }

        //construct graph
        List<Set<Integer>> adjacent = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacent.add(new HashSet<>());
        }

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjacent.get(a).add(b);
            adjacent.get(b).add(a);
        }

        //leaf nodes
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < adjacent.size(); i++) {
            if(adjacent.get(i).size() == 1)
                leaves.add(i);
        }

        while(n > 2) {
            //remove all leaf nodes
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf: leaves) {
                int neighbour = adjacent.get(leaf).iterator().next();
                adjacent.get(neighbour).remove(leaf);

                if(adjacent.get(neighbour).size() == 1)
                    newLeaves.add(neighbour);
            }
            leaves = newLeaves;
        }

        return  leaves;
    }
}
