/**
 * Created by Priyank Agrawal on 2/11/2017.
 *
 * Stock buy sell transactions problem by Dynamic programming approach
 *
 * To make given no. of transactions to buy and sell stocks in such a way that
 * it maximizes the profit
 *
 * Time complexity is O(transactions * no. of days)
 * Space complexity is O(transactions * no. of days)
 */
public class StockBuySellTransactions {

    public static void main(String[] args) {
        int[] prices = {2, 5, 7, 1, 4, 3, 1, 3};
        int transactions = 3;
        System.out.println("The maximum profit after given no. of transactions can be: " + maxProfitOptimized(prices, transactions));
    }

    //Time complexity of this solution is O(transactions^2 * no. of days)
    public static int maxProfit(int[] prices, int k) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int[][] T = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                int maxValue = 0;
                for (int m = 0; m < j; m++) {
                    maxValue = Math.max(maxValue, prices[j] - prices[m] + T[i - 1][m]);
                }
                T[i][j] = Math.max(T[i][j - 1], maxValue);
            }
        }
        return T[k][prices.length - 1];
    }

    //Time complexity of this optimized solution is O(transactions * no. of days)
    public static int maxProfitOptimized(int[] prices, int k) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int[][] T = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < prices.length; j++) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
            }
        }
        return T[k][prices.length - 1];
    }

}