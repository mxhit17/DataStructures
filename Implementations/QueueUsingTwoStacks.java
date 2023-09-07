import java.util.Stack;

public class QueueUsingTwoStacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        public static void add(int data){
            //add O(n)
            if(isEmpty()){
                s1.add(data);
            }else{
                //transfer all element to s2
                while(!isEmpty()){
                    s2.push(s1.peek());
                    s1.pop();
                }

                //add data in s1
                s1.push(data);

                //transfer all elements back to s1
                while(!s2.isEmpty()){
                    s1.push(s2.peek());
                    s2.pop();
                }
            }
        }

        public static int remove(){
            int poppedItem = -1;
            //remove
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }else{
                poppedItem = s1.peek();
                s1.pop();
            }
            return poppedItem;
        }

        public static int peek(){
            //peek
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return s1.peek();
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove() + " " + q.peek());

        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();
    }
}
