import java.util.LinkedList;
import java.util.Queue;
public class xTrail {

    public static void bubbleSort(int ary[]){
        for(int i = 0; i < ary.length; i++){
            for(int j = 0; j < ary.length - i - 1; j++){
                if(ary[j] > ary[j + 1]){
                    int temp = ary[j];
                    ary[j] = ary[j + 1];
                    ary[j + 1] = temp;
                }
            }
        }
    }

    public static void fun(LinkedList<Integer> start){
        
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        // System.out.println(q1);
        // System.out.println(q2);
        q1.add(q1.remove());
        q1.add(q1.remove());
        q1.add(q1.remove());

        q2.add(q1.remove());

        q1.add(q1.remove());
        q1.add(q1.remove());

        q2.add(q1.remove());

        q1.add(q1.remove());

        q2.add(q1.remove());
        q2.add(q1.remove());

        System.out.println(q1);
        System.out.println(q2);





    }
}