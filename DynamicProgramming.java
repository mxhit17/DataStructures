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
    }
}
