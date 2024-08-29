/*
 * @lc app=leetcode id=947 lang=java
 *
 * [947] Most Stones Removed with Same Row or Column
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();

        HashMap<Integer, ArrayList<Integer>> edges = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            if (x.get(stones[i][0]) != null) {
                edges.putIfAbsent(i, new ArrayList<>());
                edges.get(i).add(x.get(stones[i][0]));
                edges.putIfAbsent(x.get(stones[i][0]), new ArrayList<>());
                edges.get(x.get(stones[i][0])).add(i);
            }

            if (y.get(stones[i][1]) != null) {
                edges.putIfAbsent(i, new ArrayList<>());
                edges.get(i).add(y.get(stones[i][1]));
                edges.putIfAbsent(y.get(stones[i][1]), new ArrayList<>());
                edges.get(y.get(stones[i][1])).add(i);
            }

            x.put(stones[i][0], i);
            y.put(stones[i][1], i);
        }

        int[] visited = new int[stones.length];

        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            if (visited[i] == 0) {
                count += bfs(stones, edges, i, visited) - 1;
            }
        }

        return count;
    }

    private int bfs(int[][] stones, HashMap<Integer, ArrayList<Integer>> edgeList, int i, int[] visited) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int id = queue.poll();
            if (visited[id] == 1) {
                continue;
            }
            visited[id] = 1;
            count++; // Count the current node in the component size
            for (int edge : edgeList.getOrDefault(id, new ArrayList<>())) {
                if (visited[edge] == 0) {
                    queue.add(edge);
                }
            }
        }
        return count;
    }
}
// @lc code=end
