package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/8 8:33
 **/
public class S2900_getLongestSubsequence_v2 {

    @Test
    public void test() {

        String[] str = {"e", "a", "b"};
        int[] arr = {0, 0, 1};

        S2900_getLongestSubsequence_v2 exe = new S2900_getLongestSubsequence_v2();
        System.out.println(exe.getLongestSubsequence(str, arr));
    }

    @Test
    public void test1() {

        String[] str = {"a","b","c","d"};
        int[] arr = {1, 0, 1, 1};

        S2900_getLongestSubsequence_v2 exe = new S2900_getLongestSubsequence_v2();
        System.out.println(exe.getLongestSubsequence(str, arr));
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {

        int length = groups.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int[] preIndex = new int[length];
        Arrays.fill(preIndex, -1);
        int maxSubsequenceLength = 1, maxEndIndex = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    preIndex[i] = j;
                }
            }

            PrintUtil.printIntArr(dp);

            if (dp[i] > maxSubsequenceLength) {
                maxSubsequenceLength = dp[i];
                maxEndIndex = i;
            }
        }


        List<String> wordsList = new ArrayList<String>();
        int index = maxEndIndex;
        while (index >= 0) {
            wordsList.add(words[index]);
            index = preIndex[index];
        }
        Collections.reverse(wordsList);
        return wordsList;
    }
}
