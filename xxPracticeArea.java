import java.util.Arrays;

public class xxPracticeArea {
    public static void main(String args[]) {
        int dist[][] = {{0, 16, 11, 6},
                        {8, 0, 13, 16},
                        {4, 7, 0, 9},
                        {5, 12, 2, 0}};

        int n = 4;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }
    }
}

class Solution
{
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);

        int ans = 0;

        int i = n - 1;
        int j = m - 1;

        while (j != -1) {
            int x = a[i--];
            int y = b[j--];

            ans += x * y;
        }

        // for (int i = m - 1; i >= 0; i--) {
        //     int x = a[i];
        //     int y = b[i];
        //     // try {
        //     //     y = b[i];
        //     // } catch (Exception e) {
        //     //     // TODO: handle exception
        //     //     y = 0;
        //     // }

        //     ans += x * y;
        // }

        return ans;
	} 
}