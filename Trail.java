import java.util.Arrays;

public class Trail {
    public static int tilingProblem(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        
        if (memo[n] != -1) {
            return memo[n];
        }

        int fnm1 = countWays(n - 1, memo);
        int fnm2 = countWays(n - 2, memo);

        int totalWays = fnm1 + fnm2;
        memo[n] = totalWays;

        return totalWays;
    }

    public static void printAry(int ary[]){
        for(int i = 0; i < ary.length; i++){
            System.out.println(ary[i]);
        }
    }

    public static void main(String[] args) {
        int n = 100;
        int ways = tilingProblem(n);
        System.out.println("Number of ways to tile a 2 x " + n + " floor: " + ways);
    }
}
