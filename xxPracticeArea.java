public class xxPracticeArea {

    public static void printAry(int ary[]) {
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i] + " ");
        }

        System.out.println();
    }

    public static void insertionSort(int ary[]) {
        for (int i = 1; i < ary.length; i++) {
            int curr = ary[i];

            int j = i - 1;

            while (j > -1 && ary[j] > curr) {
                ary[j + 1] = ary[j];
                j = j -1;
            }

            ary[j + 1] = curr;
        }
    }

    public static void selectionSort(int ary[]) {
        for (int i = 0; i < ary.length; i++) {

            // Find Min
            int min = Integer.MAX_VALUE;
            int idx = -1;

            for (int j = i; j < ary.length; j++) {
                if (ary[j] < min) {
                    min = ary[j];
                    idx = j;
                }
            }

            int temp = ary[idx];
            ary[idx] = ary[i];
            ary[i] = temp;
        }
    }

    public static boolean isPrime(int x) {
        for (int i = x - 1; i >= 2; i--) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPrime(8));
        // Insertion Sort
        // int ary[] = {4, 2, 6, 1, 8, 5, 3};
        // insertionSort(ary);
        // printAry(ary);


        // // Selection Sort
        // selectionSort(ary);
        // printAry(ary);
    }
}