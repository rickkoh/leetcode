/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] adjList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList[u].add(new int[] { v, w });
        }

        int[] distances = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        distances[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {node, distance}
        pq.add(new int[] { k, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;

            for (int[] neighbor : adjList[currentNode]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (currentDist + weight < distances[nextNode]) {
                    distances[nextNode] = currentDist + weight;
                    pq.add(new int[] { nextNode, distances[nextNode] });
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, distances[i]);
        }

        return maxTime;
    }
}
// @lc code=end
