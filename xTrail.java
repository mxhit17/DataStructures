public class xTrail {

    public static void printAry(int ary[]) {
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int ary[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        mergeSort(ary, si, mid); // left part
        mergeSort(ary, mid + 1, ei); // right part
        merge(ary, si, mid, ei);

    }

    public static void merge(int ary[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp ary

        while (i <= mid && j <= ei) {
            if (ary[i] < ary[j]) {
                temp[k] = ary[i];
                i++;
            } else {
                temp[k] = ary[j];
                j++;
            }
            k++;
        }

        // for left
        while (i <= mid) {
            temp[k++] = ary[i++];
        }

        // for right
        while (j <= ei) {
            temp[k++] = ary[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            ary[si + m] = temp[m];
        }
    }

    public static void quickSort(int ary[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        // last index
        int pIdx = partition(ary, si, ei);
        quickSort(ary, si, pIdx - 1); // left part
        quickSort(ary, pIdx + 1, ei); // right part

    }

    public static int partition(int ary[], int si, int ei) {
        int pivot = ary[ei];
        int i = si - 1;// jagah banana or to make place for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (ary[j] <= pivot) {
                i++;
                // swap
                int temp = ary[j];
                ary[j] = ary[i];
                ary[i] = temp;

            }
        }
        i++;
        int temp = pivot;
        ary[ei] = ary[i];
        ary[i] = temp;// pivot = ary[i] nhi likhna yahan
        return i;
    }
    public static void main(String[] args) {
        int ary[] = {6, 2, 4, 1, 9, 5, 7};


        // Merge Sort
        mergeSort(ary, 0, ary.length - 1);
        printAry(ary);

        // Quick Sort
        quickSort(ary, 0, ary.length - 1);
        printAry(ary);
    }
}