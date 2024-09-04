/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obs.add(obstacles[i][0] + ", " + obstacles[i][1]);
        }

        int[] pos = new int[] { 0, 0 };

        int max = Integer.MIN_VALUE;
        int y = 400000;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                y++;
            } else if (commands[i] == -2) {
                y--;
            } else {
                int m = commands[i];
                if (y % 4 == 0) { // North
                    while (m-- > 0) {
                        if (obs.contains(pos[0] + ", " + (pos[1] + 1))) {
                            break;
                        }
                        pos[1]++;
                    }
                } else if (y % 4 == 1) { // East
                    while (m-- > 0) {
                        if (obs.contains((pos[0] + 1) + ", " + pos[1])) {
                            break;
                        }
                        pos[0]++;
                    }
                } else if (y % 4 == 2) { // South
                    while (m-- > 0) {
                        if (obs.contains(pos[0] + ", " + (pos[1] - 1))) {
                            break;
                        }
                        pos[1]--;
                    }
                } else { // West
                    while (m-- > 0) {
                        if (obs.contains((pos[0] - 1) + ", " + pos[1])) {
                            break;
                        }
                        pos[0]--;
                    }
                }

                int dist = Math.abs(pos[0] * pos[0]) + (pos[1] * pos[1]);
                max = Math.max(max, dist);
            }
        }

        return max;
    }
}
// @lc code=end
