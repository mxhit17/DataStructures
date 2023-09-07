public class QueueCircular {
    static class Queue{
        static int ary[];
        static int size;
        static int rear;
        static int front;

        Queue(int n){
            ary = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        //is empty
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        //is full
        public static boolean isFull(){
            return (rear+1) % size == front;
        }

        //add
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }

            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % size;
            ary[rear] = data;
        }

        //dequeue
        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            int result = ary[front];
            //last element delete 
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front + 1) % size;
            }
            return result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return ary[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // System.out.println(q.dequeue());
        q.dequeue();
        q.add(6);
        // System.out.println(q.dequeue());
        q.dequeue();
        q.add(7);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.dequeue();
        }

    }
}
