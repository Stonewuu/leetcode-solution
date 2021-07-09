package com.stonewu.solution.problem_7;


import javax.swing.tree.TreeNode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 */
public class Solution {

    public int reverse(int x) {
        int i = 10;
        Long result = 0L;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= i;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }
        result += x;
        return result.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1056389759));
    }
}