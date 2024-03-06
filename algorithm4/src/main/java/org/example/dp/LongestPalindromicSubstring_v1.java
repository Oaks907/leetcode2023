package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/1 16:14
 */
public class LongestPalindromicSubstring_v1 {

    @Test
    public void test() {
        String str = "babab";

        LongestPalindromicSubstring_v1 exe = new LongestPalindromicSubstring_v1();
        System.out.println(exe.LongestPalindromicSubstring(str));
    }

    private String LongestPalindromicSubstring(String str) {
        if (null == str) {
            return str;
        }

        String[] strArr = str.split("");
        String result = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            String middle = recursion(str, strArr, i, i);
            String left = recursion(str, strArr, i - 1, i);
            if (middle.length() > left.length()) {
                if (middle.length() > result.length()) {
                    result = middle;
                }
            } else {
                if (left.length() > result.length()) {
                    result = left;
                }
            }
        }
        return result;
    }

    private String recursion(String str, String[] arr, int left, int right) {
        if (right < left) {
            return "";
        }
        if (left < 0 || right > arr.length - 1) {
            return str.substring(left + 1, right);
        }
        if (!arr[left].equals(arr[right])) {
            return str.substring(left + 1, right);
        }
        return recursion(str, arr, left-1, right+1);
    }
}
