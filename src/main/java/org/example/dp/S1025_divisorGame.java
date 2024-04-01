package org.example.dp;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/26 8:28
 **/
public class S1025_divisorGame {

    public boolean divisorGame(int n) {

        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j == 0) && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
