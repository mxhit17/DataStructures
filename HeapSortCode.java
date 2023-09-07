public class HeapSortCode {

    public static void heapify(int idx, int n, int ary[]){
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int maxIdx = idx;

        if(left < n && ary[maxIdx] < ary[left]){
            maxIdx = left;
        }

        if(right < n && ary[maxIdx] < ary[right]){
            maxIdx = right;
        }

        if(maxIdx != idx){
            // swap
            int temp = ary[maxIdx];
            ary[maxIdx] = ary[idx];
            ary[idx] = temp;

            heapify(maxIdx, n, ary);
        }
    }

    public static void HeapSort(int ary[]){
        // step 1 - build max heap
        int n = ary.length;
        for(int i = n / 2; i >= 0; i--){
            heapify(i, n, ary);
        }


        // step 2 - push largest at end
        for(int i = n - 1; i >= 0; i--){
            // swap (largest-first with last)
            int temp = ary[0];
            ary[0] = ary[i];
            ary[i] = temp;

            heapify(0, i, ary);
        }
    }
    public static void main(String[] args) {
        int ary[] = {1, 2, 4, 5, 3};
        HeapSort(ary);

        for(int i = 0; i < ary.length; i++){
            System.out.print(ary[i] + " ");
        }
        System.out.println();

    }   
}
