import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueProblems {
    static class Points implements Comparable<Points>{
        int idx;
        int x;
        int y;
        int distance;

        public Points(int x, int y, int distance, int idx){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Points p2){
            return this.distance - p2.distance;
        }
    }

    public static int ropeCost(PriorityQueue<Integer> pq){
        int minCost = 0;

        while(pq.size() > 1){
            int len1 = pq.remove();
            int len2 = pq.remove();
            minCost += len1 + len2;

            pq.add(len1 + len2);
        }

        return minCost;
    }

    static class Idx implements Comparable<Idx>{
        int count1;
        int idx;
    
        public Idx(int count1, int idx){
            this.count1 = count1;
            this.idx = idx;
        }
    
        @Override
        public int compareTo(Idx i2) {
            if (this.count1 == i2.count1) {
                return this.idx - i2.idx;
            } else {
                return this.count1 - i2.count1;
            }
        }
    }
    public static int[] kWeakestRows(int[][] mat, int k) {
        int len = mat.length;
        PriorityQueue<Idx> pq = new PriorityQueue<>();
        for(int i = 0; i < len; i++){
            int count = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Idx(count, i));
        }

        int ary[] = new int[k];
        for(int i = 0; i < k; i++){
            ary[i] = pq.remove().idx;
        }

        return ary;
    }

    static class SlidingWindow implements Comparable<SlidingWindow>{
        int idx;
        int value;

        public SlidingWindow(int idx, int value){
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(SlidingWindow s2){
            return s2.value - this.value;
        }
    }

    public static ArrayList<Integer> slidingMax(int ary[], int k){
        PriorityQueue<SlidingWindow> pq = new PriorityQueue<>();
        ArrayList<Integer> a = new ArrayList<>();

        for(int i = 0; i < k; i++){
            pq.add(new SlidingWindow(i, ary[i]));
        }

        a.add(pq.peek().value);

        for(int i = k; i < ary.length; i++){
            while(pq.size() > 0 && pq.peek().idx < (i - k)){
                pq.remove();
            }
            pq.add(new SlidingWindow(i, ary[i]));
            a.add(pq.peek().value);
        }

        return a;
    }
    public static void main(String[] args) {
        // Nearest K Cars
        // int pts[][] = {{3, 3, 0}, {5, -1, 1}, {-1, 4, 2}};
        // int k = 2;

        // PriorityQueue<Points> pq = new PriorityQueue<>();
        // for(int i = 0; i < pts.length; i++){
        //     int distance = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
        //     pq.add(new Points(pts[i][0], pts[i][1], distance, pts[i][2]));
        // }

        // for(int i = 0; i < k; i++){
        //     System.out.print("C" + pq.remove().idx + " ");
        // }


        // Connect N Ropes
        // int ropes[] = {4, 3, 2, 6};
        // int ropes[] = {2, 3, 3, 4, 6};
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for(int i = 0; i < ropes.length; i++){
        //     pq.add(ropes[i]);
        // }

        // System.out.println(ropeCost(pq));


        // Weakest Soldier
        // int mat[][] = {{1, 0, 0, 0},
        //                {1, 1, 1, 1},
        //                {1, 0, 0, 0},
        //                {1, 0, 0, 0}};
        // int k = 2;
        // int weakRows[] = kWeakestRows(mat, k);
        // for(int i =0; i< weakRows.length; i++){
        //     System.out.print(weakRows[i] + " ");
        // }
        // System.out.println();


        // Sliding Window Maximum or Maximum of all subarrays of size k
        int k = 3;
        // int ary[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int ary[] = {1, 3, -1, -3, 5, 3, 6, 7};
        ArrayList<Integer> a = slidingMax(ary, k);
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();

    }
}
