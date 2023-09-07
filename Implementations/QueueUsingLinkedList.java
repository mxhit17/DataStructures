public class QueueUsingLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            this.next = null;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null;

        //is empty
        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        

        //add
        public static void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //dequeue
        public static int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            int result = head.data;
            //single element in the linked list
            if(head == tail){
                head = tail = null;
            }

            head = head.next;
            return result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
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
            try {
                q.dequeue();
            } catch (Exception e) {
                System.out.println("Null");
            }
        }

    }
}
