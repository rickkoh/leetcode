/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 */

// @lc code=start

import java.util.Queue;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;

        int[] visited = new int[isConnected.length];
        // i = current city
        for (int i = 0; i < isConnected.length; i++) {
            // i = 0, we're at city 0
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            if (visited[i] == 0) {
                count++;

                while (!queue.isEmpty()) {
                    int currentCity = queue.poll();

                    if (visited[currentCity] == 1) {
                        continue;
                    }

                    visited[currentCity] = 1;

                    for (int j = 0; j < isConnected[currentCity].length; j++) {
                        if (isConnected[currentCity][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
            }

        }

        return count;
    }
}
// @lc code=end
