import java.util.Deque;
import java.util.LinkedList;


public class DequeCode {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.addFirst(0);
        dq.addLast(3);

        while(!dq.isEmpty()){
            System.out.print(dq.getFirst() + " ");
            dq.removeFirst();
        }
        System.out.println();
    }
}
