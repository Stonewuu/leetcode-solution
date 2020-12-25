package com.stonewu.solution.problem_455;

import java.util.Arrays;

/**
 * Solution类
 *
 * @author stonewu
 * @version 1.0
 * @date 2020/12/24 15:34
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[count]) {
                count++;
            }
            if (count == g.length) {
                break;
            }
        }
        return count;
    }
}
