//Making linked list from scratch
public class LinkedList {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Methods

    public void addFirst(int data){
        //step 1 - create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step 2 - newNode = head
        newNode.next = head;

        //step 3 - head = new node
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLL(){
        Node temp = head;
        if(head == null){
            System.out.println("LL is empty...");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int index, int data){
        if(index == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while(i < index - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode; 
    }

    public int removeFirst(){
        if(size == 0){
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        //previous : i = size - 2;
        Node prev = head;
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int findKey(int key){
        int i = 0;
        if(head == null){
            System.out.println("LL is empty.");
            return -1;
        }

        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return i;
            }else{
                temp = temp.next;
            }
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);

        if(idx == -1){
            return idx;
        }
        
        return idx+1;
    }

    public int findKeyRecursive(int key){
        return helper(head, key);
    }

    public void reverseLL(){
        if(size == 0){
            System.out.println("LL is empty");
            return;
        }

        Node prev = null;
        Node curr = tail = head;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

    }

    public void removeNth(int idx){
        if(size == 0){
            System.out.println("LL is empty");
            return;
        }

        if(idx == 1){
            head = head.next;
            return;
        }
        int i = 1;

        Node temp = head;

        while(i != idx - 1){
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        size--;


    }

    public void removeNthFromBack(int idx){
        idx = size - idx + 1;
        if(idx == 1){
            head = head.next;
            return;
        }
        int i = 1;

        Node temp = head;

        while(i != idx - 1){
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        size--;
    }

    public Node findMiddle(Node head){
        //Slow fast technique
        Node s = head;
        Node f = head;

        while(f != null && f.next != null){
            s = s.next; // +1
            f = f.next.next; //+2
        }
        return s; // s is my middle node
    }

    public boolean chkPalindrome(){
        if(head == null || head.next == null){
            // System.out.println("LL is empty");
            return true;
        }
        //step 1 - find middle
        Node middle = findMiddle(head);

        //step 2 - reverse half LL from middle
        Node prev = null;
        Node curr = middle;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        //step 3 - chk if 1st half == 2nd half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean findCycle(){// Floyds cycle finding algorithm.
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        
        return false;
    }

    public void chkCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                slow = head;
                break;
            }
        }

        if(isCycle == false){
            return;
        }

        Node prev = null;
        if(isCycle){
            while(slow != fast){
                slow = slow.next;
                prev = fast;
                fast = fast.next;

                if(slow == fast){
                    prev.next = null;
                    return;
                }
            }
        }
    }

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        //base case
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = findMid(head);

        //call merge sort for lh and rh
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge method
        return merge(newLeft, newRight);
    }

    public void zigzag(){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //next is the head of second half
        Node curr = slow.next;

        //slow.next is tail pointing to null
        slow.next = null;

        //reversing the second half
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node rightHead = prev;
        Node leftHead = head;
        Node nextL, nextR;

        //zigzagging the ll
        while(leftHead != null && rightHead != null){
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            leftHead = nextL;
            rightHead = nextR;
        }
    }

    public Node reverse(Node head, int k){//Reverse a Linked List in groups of given size
        //Your code here
        Node prev = null;
        Node curr = head;
        Node next;
        int count = 0;


        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(curr != null){
            head.next = reverse(curr, k);
        }

        return prev;
    }

    public void ins(Node head, int idx){ // Pracice method for minor
        Node temp = head;
        int cntIdx = 0;
        while(cntIdx == idx){
            temp = temp.next;
        }

    }
    
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        // System.out.println(ll.chkPalindrome());
        // ll.mergeSort(head);
        // ll.zigzag();
        // ll.reverse(head, 3);
        // ll.printLL();
    }
}