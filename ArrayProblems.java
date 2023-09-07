public class ArrayProblems {
    public static void printSubarray(int ary[]){
        int ts = 0;
        for(int i = 0; i < ary.length; i++){
            int start = i;
            for(int j = i; j < ary.length; j++){
                int end = j;
                for(int k = start; k <= end; k++){
                    System.out.print(ary[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Total subarrays : " + ts);
    }

    public static int maxSubArySum(int ary[]){
        int gSum = 0;
        for(int i = 0; i < ary.length; i++){
            int start = i;
            for(int j = i; j < ary.length; j++){
                int end = j;
                int sum = 0;
                for(int k = start; k <= end; k++){
                    sum += ary[k];
                }
                if(sum > gSum){
                    gSum = sum;
                }
            }
        }

        return gSum;
    }

    public static int prefixSum(int ary[]){
        int gSum = 0;
        int prefix[] = new int[ary.length];

        // calculate prefix array
        prefix[0] = ary[0];
        for(int i = 1; i < ary.length; i++){
            prefix[i] = prefix[i - 1] + ary[i];
        }

        for(int i = 0; i < ary.length; i++){
            int start = i;
            for(int j = i; j < ary.length; j++){
                int end = j;
                int sum = 0;
                sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if(sum > gSum){
                    gSum = sum;
                }
            }
        }
        return gSum;
    }

    public static int kadane(int ary[]){
        int cs = 0;
        int ms = Integer.MIN_VALUE;

        for(int i = 0; i < ary.length; i++){
            cs += ary[i];
            if(cs < 0){
                cs = 0;
            }

            if(ms < cs){
                ms = cs;
            }
        }

        return ms;
    }
    public static void main(String[] args) {
        // Print Subarrays
        // int ary[] = {2, 4, 6, 8, 10};
        // printSubarray(ary);


        // Max Subarrays Sum
        // int ary[] = {1, -2, 6, -1, 3};
        // System.out.println(maxSubArySum(ary));


        // Max Subarray Sum - Prefix Sum
        // int ary[] = {1, -2, 6, -1, 3};
        // System.out.println(prefixSum(ary));


        // Max Subarray Sum - Kadane's Algorithm
        // int ary[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // System.out.println(kadane(ary));

    }
}
