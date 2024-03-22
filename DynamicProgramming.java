import java.util.Arrays;

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
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
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
        
    }
}
