import java.util.ArrayList;
public class Arraylist {
    public static int storeWater(ArrayList<Integer> height){
        int maxWater = Integer.MIN_VALUE;
        // TC - O(n^2)
        for(int i = 0; i < height.size(); i++){
            for(int j = i + 1; j < height.size(); j++){
                int width = j - i;
                int firstLine = height.get(i);
                int secondLine = height.get(j);
                int water = Math.min(firstLine, secondLine) * width;
                if(water > maxWater){
                    maxWater = water;
                }
            }
        }

        return maxWater;
    }

    public static int storeWater2PointerApproach(ArrayList<Integer> height){
        int lp = 0;
        int rp = height.size() - 1;

        int maxWater = Integer.MIN_VALUE;

        while(lp < rp){
            int width = rp - lp;
            int ht = Math.min(height.get(lp), height.get(rp));
            int water = width * ht;
            maxWater = Math.max(maxWater, water);

            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }

        return maxWater;
    } 

    public static void pairSum1(ArrayList<Integer> pairSum, int target){
        int e1 = 0;
        int e2 = 0;

        for(int i = 0; i < pairSum.size(); i++){
            for(int j = i + 1; j < pairSum.size(); j++){
                if(pairSum.get(i) + pairSum.get(j) == target){
                    e1 = pairSum.get(i);
                    e2 = pairSum.get(j);
                    break;
                }
            }
        }

        System.out.println(e1 + ", " + e2);
    }

    public static boolean pairSum2Pointer(ArrayList<Integer> pairSum, int target){
        int lp = 0;
        int rp = pairSum.size() - 1;

        while(lp != rp){
            if(pairSum.get(lp) + pairSum.get(rp) == target){
                return true;
            }

            if(pairSum.get(lp) + pairSum.get(rp) < target){
                lp++;
            }else if(pairSum.get(lp) + pairSum.get(rp) > target){
                rp--;
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> pairSum2, int target){
        int pivot = 0;
        for(int i = 0; i < pairSum2.size(); i++){
            if(pairSum2.get(i) > pairSum2.get(i+1)){
                pivot = i+1;
                break;
            }
        }

        int lp = pivot;
        int rp = pivot - 1;

        while(lp != rp){
            //case 1 
            if(pairSum2.get(lp) + pairSum2.get(rp) == target){
                return true;
            }

            //case 2
            if(pairSum2.get(lp) + pairSum2.get(rp) < target){
                lp = (lp + 1) % pairSum2.size();
            }

            //case 3
            if(pairSum2.get(lp) + pairSum2.get(rp) > target){
                rp = (pairSum2.size() + rp - 1) % pairSum2.size();
            }
        }
        return false;
    }

    public static boolean monotonicIncreasing(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = i; j < list.size(); j++){
                if(list.get(i) > list.get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean monotonicDecreasing(ArrayList<Integer> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = i; j < list.size(); j++){
                if(list.get(i) < list.get(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);
        // height.add(3);
        
        // System.out.println(storeWater2PointerApproach(height));

        
        //Pair Sum in a sorted list
        // ArrayList<Integer> pairSum = new ArrayList<>();
        // pairSum.add(1);
        // pairSum.add(2);
        // pairSum.add(3);
        // pairSum.add(4);
        // pairSum.add(5);
        // pairSum.add(6);
        // int target = 5;

        // pairSum1(pairSum, target);
        // System.out.println(pairSum2Pointer(pairSum, target));


        //Pair sum in a sorted rotated arraylist
        // ArrayList<Integer> pairSum2 = new ArrayList<>();
        // pairSum2.add(11);
        // pairSum2.add(15);
        // pairSum2.add(6);
        // pairSum2.add(8);
        // pairSum2.add(9);
        // pairSum2.add(10); 
        // int target = 16;
        // System.out.println(pairSum2(pairSum2, target));


        //Monotonic ArrayList
        // ArrayList<Integer> chkMonotonic = new ArrayList<>();
        // chkMonotonic.add(1);
        // chkMonotonic.add(2);
        // chkMonotonic.add(5);
        // chkMonotonic.add(4);

        // if(monotonicIncreasing(chkMonotonic)){
        //     System.out.println("Increasing");
        // }else if(monotonicDecreasing(chkMonotonic)){
        //     System.out.println("Decreasing");
        // }else{
        //     System.out.println("Not Monotonic");
        // }
    }

}
