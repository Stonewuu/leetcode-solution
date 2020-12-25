package com.stonewu.solution.problem_135;

/**
 * Solution类
 *
 * @author stonewu
 * @version 1.0
 * @date 2020/12/24 15:34
 */
public class Solution {
    public int candy(int[] ratings) {
        int total = 0;
        int tempup = 1;
        int[] candys = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            tempup = ratings[i] > (i == 0 ? ratings[i] : ratings[i - 1]) ? tempup + 1 : 1;
            candys[i] = (tempup);
        }
        tempup = 1;
        for (int i = ratings.length - 1; i >= 0; i--) {
            tempup = ratings[i] > (i == ratings.length - 1 ? ratings[i] : ratings[i + 1]) ? tempup + 1 : 1;
            total += candys[i] < tempup ? tempup : candys[i];
        }
        return total;
    }
}
