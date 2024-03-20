package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/19 8:34
 **/
public class S0392_isSubsequence_v2_1 {

    @Test
    public void test() {
        S0392_isSubsequence_v2_1 isSubsequence = new S0392_isSubsequence_v2_1();
        System.out.println(isSubsequence.isSubsequence("ace", "abcde"));
    }

    @Test
    public void test1() {
        S0392_isSubsequence_v2_1 isSubsequence = new S0392_isSubsequence_v2_1();
        System.out.println(isSubsequence.isSubsequence("aca", "abcde"));
    }

    @Test
    public void test2() {
        S0392_isSubsequence_v2_1 isSubsequence = new S0392_isSubsequence_v2_1();
        System.out.println(isSubsequence.isSubsequence("acb", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || "".equals(s)) {
            return true;
        }

        int sLen = s.length();
        int tLen = t.length();
        if (tLen < sLen) {
            return false;
        }

        char c = s.charAt(0);
        int tPreMatchIndex = -1;
        int sPreMatchIndex = -1;


        for (int i = 0; i < tLen; i++) {
            if (c == t.charAt(i)) {
                tPreMatchIndex = i;
                sPreMatchIndex = 0;
            }
        }

        for (int i = 1; i < sLen; i++) {
            char a = s.charAt(i);

            if (tPreMatchIndex == -1) {
                return false;
            }

            for (int j = tPreMatchIndex + 1; j < tLen; j++) {
                if (a == t.charAt(j)) {
                    tPreMatchIndex = j;
                    sPreMatchIndex = i;
                    break;
                } else {
                    tPreMatchIndex = -1;
                }
            }
        }

        return tPreMatchIndex != -1 && sPreMatchIndex == sLen - 1;
    }
}
