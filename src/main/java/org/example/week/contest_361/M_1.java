package org.example.week.contest_361;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 *
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 *
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 *
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 */
public class M_1 {

    int minValue = Integer.MAX_VALUE;
    Set<Integer> set = new HashSet<>();

    public int minimumOperations(String num) {
        boolean[] hadDelete = new boolean[num.length()];
        recursion(num, hadDelete, 0, 0);
        return minValue;
    }

    public void recursion(String num, boolean[] hadDelete, int operaCount, int index) {

        if (operaCount >= minValue) {
            return;
        }

        String valStr = "";
        for (int i = 0; i < num.length(); i++) {
            if (!hadDelete[i]) {
                valStr += num.charAt(i);
            }
        }
        if (valStr.isEmpty() || "0".equals(valStr)) {
            minValue = Math.min(minValue, operaCount);
            return;
        }

        if (valStr.length() >= 2) {
            String str = valStr.substring(valStr.length() - 2, valStr.length());
            // 00、25、50、75
            if ("00".equals(str) || "25".equals(str) || "50".equals(str) || "75".equals(str)) {
                minValue = Math.min(minValue, operaCount);
                return;
            }
        }

        for (int i = index; i < num.length(); i++) {
            if (hadDelete[i]) {
                continue;
            }
            hadDelete[i] = true;
            recursion(num, hadDelete, operaCount + 1, index + 1);
            hadDelete[i] = false;
        }
    }

    public static void main(String[] args) {
        M_1 exe = new M_1();
        System.out.println(exe.minimumOperations("10"));
//        System.out.println(exe.minimumOperations("2908305"));
//        System.out.println(exe.minimumOperations("2245047"));
        System.out.println(exe.minimumOperations("6525479784667"));
    }
}
