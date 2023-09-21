public class StackUsingLinkedList {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    static class Stack{
        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Node tailPrev(){
            Node prev = null;
            Node temp = head;
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }

            return prev;
        }
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }else{
                Node tailP = tailPrev();
                int temp = tail.data;
                tail = null;
                tail = tailP;
                return temp;
            }
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }else{
                // Node tailP = tailPrev();
                int temp = tail.data;
                // tail = null;
                // tail = tailP;
                return temp;
            }
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(10);
        

    }
}
