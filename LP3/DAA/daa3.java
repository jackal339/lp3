//Write a program to solve a 0-1 Knapsack problem using dynamic programming or branch and bound strategy.


import java.util.Scanner;

public class daa3 {

    public static int[][] knapsack(int W, int[] profits, int[] weights, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i] <= w) {
                    dp[i][w] = Math.max(profits[i] + dp[i - 1][w - weights[i]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp;
    }

    public static void printSelectedItems(int[][] dp, int[] weights, int n, int W) {
        int i = n;
        int j = W;

        System.out.println("\nSelected items:");
        while (i > 0) {
            if (j >= weights[i] && dp[i][j] != dp[i - 1][j]) {
                System.out.println("Item " + i + " = 1");
                j = j - weights[i];
            } 
            else {
                System.out.println("Item " + i + " = 0");
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total number of items: ");
        int n = sc.nextInt();

        int[] weights = new int[n + 1];
        int[] profits = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter weight and profit for item " + i + ": ");
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }

        System.out.println("Enter the capacity of the bag: ");
        int W = sc.nextInt();

        int[][] dp = knapsack(W, profits, weights, n);
        int maxProfit = dp[n][W];
        System.out.println("\nMax Profit: " + maxProfit);

        printSelectedItems(dp, weights, n, W);

        sc.close();
    }
}
