public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add
    //add first
    public void addFirst(int data){
        //create new Node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        //pointing next and prev
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
    }

    //printing dll
    public void printDLL(){
        if(head == null){
            System.out.println("The doubly linked list is empty.");
            return;
        }
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // remove
    //remove first
    public void removeFirst(){
        if(head == null){
            return;
        }
        if(head == tail){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    // remove last
    public void removeLast(){
        if(head == null){
            return;
        }
    
        if(size == 1){
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    
        size--;
    }

    public void reverseDLL(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.addLast(7);
        dll.printDLL();
        System.out.println();
        dll.reverseDLL();
        System.out.println();
        dll.printDLL();

        
    }
}
