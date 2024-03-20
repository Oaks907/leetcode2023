package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/19 8:34
 **/
public class S0392_isSubsequence_v2_2 {

    @Test
    public void test() {
        S0392_isSubsequence_v2_2 isSubsequence = new S0392_isSubsequence_v2_2();
        System.out.println(isSubsequence.isSubsequence("ace", "abcde"));
    }

    @Test
    public void test1() {
        S0392_isSubsequence_v2_2 isSubsequence = new S0392_isSubsequence_v2_2();
        System.out.println(isSubsequence.isSubsequence("aca", "abcde"));
    }

    @Test
    public void test2() {
        S0392_isSubsequence_v2_2 isSubsequence = new S0392_isSubsequence_v2_2();
        System.out.println(isSubsequence.isSubsequence("acb", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        int i = 0;
        int j = 0;

        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == sLen;
    }
}
