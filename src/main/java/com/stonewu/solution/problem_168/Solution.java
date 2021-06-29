package com.stonewu.solution.problem_168;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 * <p>
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 */
public class Solution {

    public String convertToTitle(int columnNumber) {
        if (columnNumber < 27) {
            return String.valueOf((char) (64 + columnNumber));
        }
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 26) {
            columnNumber = columnNumber / 26;
            System.out.println(columnNumber);
            sb.insert(0, (char) (65 + columnNumber));
        }
        sb.insert(0, (char) (64 + columnNumber));

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(27));
    }

}