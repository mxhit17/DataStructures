public class xTrail{
    static class Queue{
        static class Node{
            int data;
            Node next;

            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }

        static int size = 0;
        static Node head = null;
        static Node tail = null;

        public boolean isEmpty(){
            return size == 0;
        }

        public void addLast(int data){
            Node newNode = new Node(data);
            if(size == 0){
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
                newNode.next = null;
            }
            size++;
        }

        public int removeFirst(){
            if(size == 0){
                System.out.println("LL is empty");
                return -1;
            }else{
                int temp = head.data;
                head = head.next;
                size--;
                return temp;
            }
        }

    }

    
    public static void main(String[] args) {
        Queue q = new Queue();
        
    }
}