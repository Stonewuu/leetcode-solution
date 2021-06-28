package com.stonewu.solution.problem_815;

import java.util.*;

/**
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 * <p>
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 */
public class Solution {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        List<Set<Integer>> stationArr = new ArrayList<>();
        Map<Integer, Set<Integer>> stationLine = new HashMap<>();
        Set<Integer> repeatLine = new HashSet<>();
        for (int i = 0; i < routes.length; i++) {
            stationArr.add(new HashSet<>());
            for (int station : routes[i]) {
                stationArr.get(i).add(station);
                Set<Integer> set = stationLine.getOrDefault(station, new HashSet<>());
                set.add(i);
                stationLine.put(station, set);
            }
        }
        int change = 0;
        while (!queue.isEmpty()) {
            change++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer now = queue.poll();
                Set<Integer> lines = stationLine.get(now);
                if(repeatLine.containsAll(lines)){
                    continue;
                }
                repeatLine.addAll(lines);
                List<Integer> stations = getStations(stationArr, lines);
                for (Integer station : stations) {
                    if (station.equals(target)) {
                        return change;
                    }
                    queue.offer(station);
                }
            }
        }
        return -1;
    }

    public static List<Integer> getStations(List<Set<Integer>> stationArr, Set<Integer> lines) {
        List<Integer> results = new ArrayList<>();
        for (Integer line : lines) {
            results.addAll(stationArr.get(line));
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] arr = new int[100][1000];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                arr[i][j] = i * 1000 + j - i;
            }
        }

        long time = System.currentTimeMillis();
        System.out.println(numBusesToDestination(arr, 1, 99900));
        time = System.currentTimeMillis() - time;
        System.out.println(time);
    }

}