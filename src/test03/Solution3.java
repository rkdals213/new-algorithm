package test03;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        String L1 = "..xx.x.";
        String L2 = "x.x.x..";
        System.out.println(solution(L1, L2));
    }

    public static int solution(String L1, String L2) {
        int max = 0;
        int[][] dp = new int[4][L1.length() + 2];
        int size = L1.length();

        for (int i = 0; i < L1.length(); i++) {
            if (L1.charAt(i) == 'x') {
                dp[0][i + 1] = dp[0][i] + 1;
            } else {
                dp[0][i + 1] = dp[0][i];
            }

            if (L2.charAt(size - i - 1) == 'x') {
                dp[1][size - i] = dp[1][size - i + 1] + 1;
            } else {
                dp[1][size - i] = dp[1][size - i + 1];
            }

            if (L1.charAt(size - i - 1) == 'x') {
                dp[2][size - i] = dp[2][size - i + 1] + 1;
            } else {
                dp[2][size - i] = dp[2][size - i + 1];
            }

            if (L2.charAt(i) == 'x') {
                dp[3][i + 1] = dp[3][i] + 1;
            } else {
                dp[3][i + 1] = dp[3][i];
            }
        }

        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));


        for (int i = 0; i < dp[0].length - 2; i++) {
            int count = dp[0][i] + dp[1][i + 2];
            if (count > max) max = count;

            count = dp[2][i + 2] + dp[3][i];
            if (count > max) max = count;
        }

        int dp1 = dp[0][dp[0].length - 2];
        int dp2 = dp[1][1];
        int dp3 = dp[2][dp[2].length - 2];
        int dp4 = dp[3][1];

        if (dp1 > max) max = dp1;
        if (dp2 > max) max = dp2;
        if (dp3 > max) max = dp3;
        if (dp4 > max) max = dp4;

        return max;
    }
}
