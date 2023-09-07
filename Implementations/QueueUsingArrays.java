public class QueueUsingArrays {
    static class Queue{
        static int ary[];
        static int size;
        static int rear;

        Queue(int n){
            ary = new int[n];
            size = n;
            rear = -1;
        }

        //is empty
        public static boolean isEmpty(){
            return rear == -1;
        }

        //add
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full.");
                return;
            }

            rear = rear + 1;
            ary[rear] = data;
        }

        //dequeue
        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            int temp = ary[0];

            for(int i = 0; i < ary.length - 1; i++){
                ary[i] = ary[i+1];
            }
            rear = rear - 1;
            return temp;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return ary[0];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.print(q.peek() + " ");
            q.dequeue();
        }

    }
}
