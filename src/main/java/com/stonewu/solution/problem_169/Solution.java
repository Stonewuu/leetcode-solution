package com.stonewu.solution.problem_169;


import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            int max = result.getOrDefault(num, 0) + 1;
            if (max > nums.length / 2) {
                return num;
            }
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}