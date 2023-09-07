import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue{
        static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //add
        public static void add(int data){
            dq.addLast(data);
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int removedItem = dq.getFirst();
            dq.removeFirst();
            return removedItem;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        // q.remove();

        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
