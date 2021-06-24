package com.stonewu.solution.problem_149;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 */
public class Solution {
    public static int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            int nowmax = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int x = x2 - x1;
                int y = y2 - y1;
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + "_" + y;
                int num = map.getOrDefault(key, 0) + 1;
                map.put(key, num);
                nowmax = Math.max(num, nowmax);
            }
            max = Math.max(max, nowmax + 1);
        }
        return max;
    }

    public static int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        maxPoints(arr);
    }
}