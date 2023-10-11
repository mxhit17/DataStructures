import java.util.LinkedList;

public class JavaBasics{
    public static LinkedList<Integer> mergeLL(LinkedList<Integer> L1, LinkedList<Integer> L2){
        LinkedList<Integer> L3 = new LinkedList<>();
        while(!L1.isEmpty()){
            L3.add(L1.removeFirst());
        }
        while(!L2.isEmpty()){
            L3.add(L2.removeFirst());
        }

        return L3;
    }

    public static void main(String[] args) {
        LinkedList<Integer> L1 = new LinkedList<>();
        L1.addLast(1);
        L1.addLast(2);
        L1.addLast(3);
        LinkedList<Integer> L2 = new LinkedList<>();
        L2.addLast(4);
        L2.addLast(5);
        L2.addLast(6);
        System.out.println(mergeLL(L1, L2));
    }
}