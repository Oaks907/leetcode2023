package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/19 8:34
 **/
public class S0392_isSubsequence_v1_2 {

    @Test
    public void test() {
        S0392_isSubsequence_v1_2 isSubsequence = new S0392_isSubsequence_v1_2();
        System.out.println(isSubsequence.isSubsequence("ace", "abcde"));
    }

    @Test
    public void test1() {
        S0392_isSubsequence_v1_2 isSubsequence = new S0392_isSubsequence_v1_2();
        System.out.println(isSubsequence.isSubsequence("aca", "edcaa"));
    }

    public boolean isSubsequence(String s, String t) {

        return true;
    }
}
