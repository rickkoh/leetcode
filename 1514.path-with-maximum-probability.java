/*
 * @lc app=leetcode id=1514 lang=java
 *
 * [1514] Path with Maximum Probability
 */

// @lc code=start

import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

    static class Edge {
        int node;
        double prob;

        public Edge(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adjList.get(u).add(new Edge(v, prob));
            adjList.get(v).add(new Edge(u, prob));
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.add(new double[] { start_node, 1 });

        double[] weights = new double[n];
        weights[start_node] = 1;

        while (!pq.isEmpty()) {

            double[] current = pq.poll();
            int node = (int) current[0];
            double prob = current[1];

            if (node == end_node) {
                return prob;
            }

            for (Edge edge : adjList.get(node)) {
                double new_prob = prob * edge.prob;
                if (new_prob > weights[edge.node]) {
                    weights[edge.node] = new_prob;
                    pq.add(new double[] { edge.node, new_prob });
                }
            }

        }

        return 0;

    }
}
// @lc code=end
