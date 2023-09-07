import java.util.ArrayList;

public class PriorityQueueCode {
    static class Heap {
        ArrayList<Integer> ary = new ArrayList<>();

        public void add(int data) {
            // Add to the end of the heap
            ary.add(data);

            int childIdx = ary.size() - 1;
            int parentIdx = (childIdx - 1) / 2;

            while (ary.get(childIdx) < ary.get(parentIdx)) {
                // Swap elements
                int temp = ary.get(childIdx);
                ary.set(childIdx, ary.get(parentIdx));
                ary.set(parentIdx, temp);

                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        public int peek() {
            return ary.get(0);
        }

        private void heapify(int idx) {
            int leftChild = 2 * idx + 1;
            int rightChild = 2 * idx + 2;
            int minIdx = idx;

            if(leftChild < ary.size() && ary.get(minIdx) > ary.get(leftChild)){
                minIdx = leftChild;
            }

            if(rightChild < ary.size() && ary.get(minIdx) > ary.get(rightChild)){
                minIdx = rightChild;
            }

            if(minIdx != idx){
                // swapping
                int temp = ary.get(minIdx);
                ary.set(minIdx, ary.get(idx));
                ary.set(idx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            if (ary.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }

            int data = ary.get(0);

            // Replace root with the last element
            ary.set(0, ary.get(ary.size() - 1));
            ary.remove(ary.size() - 1);

            // Heapify the root
            // heapify(0);
            makeMaxHeap(0);
            return data;
        }

        public boolean isEmpty() {
            return ary.isEmpty();
        }

        public void makeMaxHeap(int idx){
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int maxIdx = idx;

            if(left < ary.size() && ary.get(maxIdx) < ary.get(left)){
                maxIdx = left;
            }else{
                // return;
            }

            if(right < ary.size() && ary.get(maxIdx) < ary.get(right)){
                maxIdx = right;
            }

            if(maxIdx != idx){
                // swapping
                int temp = ary.get(maxIdx);
                ary.set(maxIdx, ary.get(idx));
                ary.set(idx, temp);

                makeMaxHeap(maxIdx);
            }
        }
    }

    public static void main(String[] args) {
        // Heap Implementation
        Heap h = new Heap();
        h.add(1);
        h.add(2);
        h.add(4);
        h.add(5);
        h.add(3);

        for(int i = (h.ary.size() / 2); i >= 0; i--){
            h.makeMaxHeap(i);
        }

        while (!h.isEmpty()) {
            System.out.print(h.remove() + " ");
        }
    }
}
