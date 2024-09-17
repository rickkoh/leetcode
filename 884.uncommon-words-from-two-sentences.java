/*
 * @lc app=leetcode id=884 lang=java
 *
 * [884] Uncommon Words from Two Sentences
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashSet<String> a = new HashSet<>();
        HashSet<String> b = new HashSet<>();

        for (String s : s1.split(" ")) {
            boolean inA = a.contains(s);
            boolean inB = b.contains(s);
            if (inA || inB) {
                a.remove(s);
                b.add(s);
            } else {
                a.add(s);
            }
        }

        for (String s : s2.split(" ")) {
            boolean inA = a.contains(s);
            boolean inB = b.contains(s);
            if (inA || inB) {
                a.remove(s);
                b.add(s);
            } else {
                a.add(s);
            }
        }

        return a.toArray(new String[a.size()]);
    }
}
// @lc code=end
