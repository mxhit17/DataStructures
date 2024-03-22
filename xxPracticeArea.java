import java.util.Arrays;
import java.util.Collections;

public class xxPracticeArea {
    static int max(int a, int b) { return (a > b) ? a : b; }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];


        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                        = max(val[i - 1]
                                  + K[i - 1][w - wt[i - 1]],
                              K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String args[])
    {
        int profit[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
}

class Solution {
    public static int minElements(int n, int m, int[] arr1, int[] arr2) {
        // code here
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr1[i];
        }

        Arrays.sort(arr2);

        int count = 0;
        int check = 0;

        for (int i = m - 1; i >= 0; i--) {
            check += arr2[i];
            count += 1;

            if (check >= sum) {
                return count;
            }
        }

        return -1;
    }
}