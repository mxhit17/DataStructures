public class Recursion {
    public static void decNum(int n){

        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        decNum(n - 1);

    }

    public static void incNum(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        incNum(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n){
        if(n == 0){
            return 1;
        }

        // int fnm1 = factorial(n - 1);
        int fn = n * factorial(n - 1);
        return fn;
    }

    public static int natSum(int n){
        if(n == 0){
            return 0;
        }

        // int x = natSum(n - 1);
        int sum = n + natSum(n - 1);
        return sum;

    }

    public static int fibonaciiSer(int n){
        if(n == 0 || n == 1){
            return n;
        }

        int fnm1 = fibonaciiSer(n - 1);
        int fmn2 = fibonaciiSer(n - 2);
        int fn = fnm1 + fmn2;

        return fn;
        
    }

    public static boolean chkSortedAry(int ary[], int i){
        if(i == ary.length - 1){
            return true;
        }
        if(ary[i] > ary[i + 1]){
            return false;
        }

        return chkSortedAry(ary, i + 1);
    }

    public static int firstOccurence(int ary[], int key, int i){
        if(key == ary[ary.length - 1]){
            return ary.length - 1;
        }

        if(key == ary[i]){
            return i;
        }

        return firstOccurence(ary, key, i++);
    }

    public static int lastOccurence(int ary[], int key, int i){
        if(i == ary.length){
            return -1;
        }
        int isFound = lastOccurence(ary, key, i+1);
        if(isFound == -1){
            if(key == ary[i]){
                return i;
            }else{
                return -1;
            }
        }else{
            return isFound;
        }
    }

    public static int pow(int x, int n){
        if(n == 1){
            return x;
        }
        return x * pow(x, n-1);
    }

    public static int optimizedPow(int x, int n){
        //TC = O(n)
        if(n == 0){
            return 1;
        }
        int halfPowerSq = optimizedPow(x, n/2) * optimizedPow(x, n/2);

        //if n is a odd number 
        if(n % 2 != 0){
            int res = halfPowerSq * x;
            return res;
        }
        return halfPowerSq;
    }

    public static long optimizedPow2(int x, int n){
        //TC = O(log n)
        if(n == 0){
            return 1;
        }
        long halfPowerSq = optimizedPow(x, n/2);
        long power = halfPowerSq * halfPowerSq;

        //if n is a odd number 
        if(n % 2 != 0){
            long res = power * x;
            return res;
        }
        return power;
    }

    public static int tilingProblem(int n){ // floor size 2 * n
        //base case
        if(n == 0 || n == 1){
            return 1;
        }
        //vertical choice 
        int fnm1 = tilingProblem(n - 1);
        //horizontal choice
        int fnm2 = tilingProblem(n - 2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void duplicateString(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true){
            //duplicate
            duplicateString(str, idx+1, newStr, map);
        }else{
            //firstTime
            map[currChar - 'a'] = true;
            duplicateString(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int frndsPairing(int n) {
        //base case
        if(n == 1 || n == 2){
            return n;
        }

        //choice
        //single
        int fnm1 = frndsPairing(n-1);

        //pairing
        int fnm2 = frndsPairing(n-2);
        int pairWays = (n-1) * fnm2;

        //totalways
        int totalWays = fnm1 + pairWays;
        return totalWays;
    }

    public static void printBinaryString(int n, int lastplace, String newStr){
        //basecase
        if(n == 0){
            System.out.println(newStr);
            return;
        }

        //kaam
        printBinaryString(n-1, 0, newStr+'0');
        if(lastplace == 0){
            printBinaryString(n-1, 1, newStr+'1');
        }
    }
    public static void main(String args[]){
        // int sorted[] = {1, 2, 5, 3, 4, 5, 6, 7, 8, 9};
        // int i = 0;
        // int key = 5;
        // int x = 10;
        // int n = 3;
        // boolean map[] = new boolean[26];
        // String str = "appnnacollege";
        // int idx = 0;



        // duplicateString(str, idx, new StringBuilder(""), map);
        // printBinaryString(10, 0, "");
        // System.out.println(frndsPairing(n));
    }
}
