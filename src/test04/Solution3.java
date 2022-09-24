package test04;

import java.util.Arrays;

public class Solution3 {
    private static int maxPlusCount = 0;
    private static int maxSalePrice = 0;
    private static int[] result;

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        System.out.println(Arrays.toString(solution(users, emoticons)));
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        result = new int[emoticons.length];

        dfs(users, emoticons, new int[emoticons.length], 0);

        result = new int[]{maxPlusCount, maxSalePrice};

        return result;
    }

    private static void dfs(int[][] users, int[] emoticons, int[] ratio, int depth) {
        if (depth == emoticons.length) {
            int plusCount = 0;
            int salePrice = 0;

            for (int i = 0; i < users.length; i++) {
                int price = 0;
                for (int j = 0; j < ratio.length; j++) {
                    if (users[i][0] <= ratio[j]) {
                        price += emoticons[j] * (100 - ratio[j]) / 100;
                    }
                }

                if (price >= users[i][1]) {
                    price = 0;
                    plusCount++;
                }

                salePrice += price;
            }

            if (plusCount > maxPlusCount) {
                maxPlusCount = plusCount;
                maxSalePrice = salePrice;
                result = ratio;
            } else if (plusCount == maxPlusCount) {
                if (salePrice > maxSalePrice) {
                    maxPlusCount = plusCount;
                    maxSalePrice = salePrice;
                    result = ratio;
                }
            }

            return;
        }

        for (int i = 1; i < 5; i++) {
            ratio[depth] = i * 10;
            dfs(users, emoticons, ratio, depth + 1);
        }
    }
}
