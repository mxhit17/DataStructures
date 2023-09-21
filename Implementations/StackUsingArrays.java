public class StackUsingArrays {
    static class Stack{
        int size = 0;
        int n;
        int ary[];
        public Stack(int n){
            this.n = n;
            ary = new int[n];
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public boolean isFull(){
            return size == n;
        }

        public void push(int data){
            if(isFull()){
                System.out.println("Stack is full");
                return;
            }
            ary[size] = data;
            size++;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty.");
                return -1;
            }else{
                return ary[size];
            }
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is Empty.");
                return -1;
            }else{
                size--;
                int temp = ary[size];
                ary[size] = 0;
                return temp;
            }
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack(3);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(10);
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
}
