/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if (isNumeric(expression)) {
            result.add(Integer.parseInt(expression));
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String a = expression.substring(0, i);
                String b = expression.substring(i + 1);
                List<Integer> aResult = diffWaysToCompute(a);
                List<Integer> bResult = diffWaysToCompute(b);
                for (int x : aResult) {
                    for (int y : bResult) {
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else if (c == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        return result;
    }
}
// @lc code=end
