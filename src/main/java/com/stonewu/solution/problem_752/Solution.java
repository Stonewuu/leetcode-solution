package com.stonewu.solution.problem_752;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 */
public class Solution {
    public static int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> deadendSet = Arrays.stream(deadends).collect(Collectors.toSet());
        if (deadendSet.contains("0000")) {
            return -1;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");


        Set<String> exists = new HashSet<>();
        exists.add("0000");

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String now = queue.poll();
                List<String> nextLocks = getNextLocks(now);
                for (String nextLock : nextLocks) {
                    if (!exists.contains(nextLock) && !deadendSet.contains(nextLock)) {
                        if (nextLock.equals(target)) {
                            return count;
                        }
                        exists.add(nextLock);
                        queue.offer(nextLock);
                    }

                }

            }
        }
        return -1;
    }

    public static char plusNum(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }

    public static char minusNum(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }

    public static List<String> getNextLocks(String now) {
        char[] chars = now.toCharArray();
        List<String> nextLocks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = chars[i];
            chars[i] = plusNum(c);
            nextLocks.add(new String(chars));
            chars[i] = minusNum(c);
            nextLocks.add(new String(chars));
            chars[i] = c;
        }
        return nextLocks;
    }

    public static void main(String[] args) {
        String[] dead = new String[]{"0201","0101","0102","1212","2002"};
        int lock = openLock(dead, "0202");
        System.out.println(lock);
    }
}