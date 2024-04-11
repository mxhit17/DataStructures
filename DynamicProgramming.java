// import java.util.*;

import javax.swing.plaf.synth.SynthStyle;

public class DynamicProgramming {
    public static int fibonacci(int n){     // purely recurrsive    TC = O(2^n)
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibMemoization(int n, int f[]){    // DP   TC = O(N)
        if (n == 0 || n == 1) {
            return n;
        }

        if (f[n] != 0) { // fibonacci already calculated
            return f[n];
        }

        f[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return f[n];
    }

    public static int fibTabulation(int n){ // Tabulation   TC = O(N)
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int climbingStairs(int n){
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int one = climbingStairs(n - 1);
        int two = climbingStairs(n - 2);

        return one + two;
    }

    public static int climbingStairs(int n, int ways[]){
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) {
            return ways[n];
        }

        ways[n] = climbingStairs(n - 1, ways) + climbingStairs(n - 2, ways);

        return ways[n];
    }

    public static void climbingStairsTabulation(int n, int ary[]) {
        ary[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ary[i] = ary[i - 1];
            } else {
                ary[i] = ary[i - 1] + ary[i - 2];
            }
        }
    }

    public static int knapSack(int val[], int wt[], int W, int n){
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapSack(val, wt, W - wt[n - 1], n - 1);

            // exclude
            int ans2 = knapSack(val, wt, W, n - 1);

            return Math.max(ans1, ans2);
        } else { // not valid
            return knapSack(val, wt, W, n - 1);
        }
    }
    public static int knapSackMemo(int val[], int wt[], int W, int n, int dp[][]){ // O(n * W)
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapSackMemo(val, wt, W - wt[n - 1], n - 1, dp);

            // exclude
            int ans2 = knapSackMemo(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);

            return dp[n][W];
        } else { // not valid
            dp[n][W] = knapSackMemo(val, wt, W, n - 1, dp);

            return dp[n][W];
        }
    }

    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        // Initialization
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) { // Valid Case
                    // Include
                    int incProfit = v + dp[i - 1][j - w];
                    // Exclude
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // Invalid Case
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = excProfit;
                }
            }
        }

        return dp[n][W];
    }

    public static void printDP(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {
                    System.out.print("T" + " ");
                } else {
                    System.out.print("F" + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean targetSum(int numbers[], int target) { // O(n * target)
        boolean dp[][] = new boolean[numbers.length + 1][target + 1];

        for (int i = 0; i < numbers.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i < target + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < numbers.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int v = numbers[i - 1];
                // Include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        printDP(dp);

        return dp[numbers.length][target];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int unBoundedKsTab(int val[], int wt[], int W) { // O(n * W)
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        // Initialization
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) { // Valid Case
                    // Include
                    int incProfit = v + dp[i][j - w];
                    // Exclude
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { // Invalid Case
                    int excProfit = dp[i - 1][j];

                    dp[i][j] = excProfit;
                }
            }
        }

        printDP(dp);

        return dp[n][W];
    }

    public static int coinChange(int coins[], int sum) {
        int dp[][] = new int[coins.length + 1][sum + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int c = coins[i - 1];

                if (c <= j) { // Valid
                    // Include
                    int incProfit = dp[i][j - c];

                    // Exclude
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = incProfit + excProfit;
                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }

        return dp[coins.length][sum];
    }

    public static int rodCutting(int lengths[], int prices[], int rodLength) {
        int n = lengths.length;
        int W = rodLength;

        int dp[][] = new int[n + 1][W + 1];

        // for (int i = 0; i < W + 1; i++) {
        //     dp[0][i] = 0;
        // }

        // for (int i = 0; i < n + 1; i++) {
        //     dp[i][0] = 0;
        // }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int p = prices[i - 1];
                int l = lengths[i - 1];
                
                if (l <= j) { // Valid
                    dp[i][j] = Math.max(p + dp[i][j - l], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }


    public static int lcs(String str1, String str2, int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        }

        char ch1 = str1.charAt(n);
        char ch2 = str2.charAt(m);

        if (ch1 == ch2) {
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else {
            int a = lcs(str1, str2, n - 1, m);
            int b = lcs(str1, str2, n, m - 1);
            return Math.max(a, b);
        }
    }
    public static void main(String[] args) {
        // Fibonacci Series
        // int n = 5;
        // int f[] = new int[n + 1];
        // System.out.println(fibMemoization(5, f));
        // System.out.println(fibTabulation(n));


        // Climbing Stairs
        // int n = 5;
        // System.out.println(climbingStairs(n));
        // int ways[] = new int[n + 1];
        // Arrays.fill(ways, -1);
        // System.out.println(climbingStairs(n, ways));

        // int waysTab[] = new int[n + 1];
        // climbingStairsTabulation(n, waysTab);
        // System.out.println(waysTab[n]);


        // 0/1 Knapsack
        // Recursion
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int W = 7;
        // System.out.println(knapSack(val, wt, W, val.length));

        // Memoization
        // int dp[][] = new int[val.length + 1][W + 1];
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapSackMemo(val, wt, W, val.length, dp));

        // Tabulation
        // System.out.println(knapsackTab(val, wt, W));


        // Target Sum Subset
        // int numbers[] = {4, 2, 7, 1, 3};
        // int target = 10;
        // System.out.println(targetSum(numbers, target));


        // Unbounded Knapsack
        // int val[] = {15, 14, 10, 45, 30};
        // int wt[] = {2, 5, 1, 3, 4};
        // int W = 7;
        // System.out.println(unBoundedKsTab(val, wt, W));


        // Coin Change
        // int[] coins = {2, 5, 3, 6};
        // int sum = 10;
        // System.out.println(coinChange(coins, sum));


        // Rod Cutting
        // int lengths[] = {1, 2, 3, 4, 5, 6, 7, 8};
        // int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        // int rodLength = 8;
        // System.out.println(rodCutting(lengths, prices, rodLength));


        // Longest Common Subsequence
        // String str1 = "abcde";
        // String str2 = "ace";
        // System.out.println(lcs(str1, str2, str1.length() - 1, str2.length() - 1));
    }
}