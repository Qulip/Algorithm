import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
        System.out.println(Arrays.toString(solution(
                new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                new int[]{1300, 1500, 1600, 4900})));
    }

    public static int[] result;

    public static int[] solution(int[][] users, int[] emoticons) {
        result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

        dfs(emoticons.length, 0, new int[emoticons.length], emoticons, users);

        return result;
    }

    public static void dfs(int n, int idx, int[] amounts, int[] emoticons, int[][] users) {
        if (n == idx) {
            int emoticonPlus = 0;
            int sales = 0;
            for (int[] user : users) {
                int userSales = 0;
                for (int i = 0; i < amounts.length; i++) {
                    if (amounts[i] >= user[0]) {
                        userSales += emoticons[i] / 100 * (100 - amounts[i]);
                    }
                }
                if (userSales >= user[1]) {
                    emoticonPlus++;
                } else {
                    sales += userSales;
                }
            }
            if (result[0] < emoticonPlus) {
                result[0] = emoticonPlus;
                result[1] = sales;
            } else if (result[0] == emoticonPlus) {
                result[1] = result[1] > sales ? result[1] : sales;
            }
            return;
        }

        for (int i = 1; i < 5; i++) {
            amounts[idx] = i * 10;
            dfs(n, idx + 1, amounts, emoticons, users);
        }
    }
}