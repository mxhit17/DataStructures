import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //push
        public static void push(int data){
            dq.addLast(data);
        }

        //pop
        public static int pop(){
            return dq.removeLast();
        }

        //peek
        public static int peek(){
            return dq.getLast();
        }
    } 

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();
    }   
}