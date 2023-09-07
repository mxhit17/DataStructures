import java.util.*;

public class StackCode {
    public static void pushFromBottom(Stack<Integer> s, int key){
        if(s.isEmpty()){
            s.push(key);
            return;
        }

        //recursion
        int temp = s.pop();
        pushFromBottom(s, key);
        s.push(temp);
    }

    public static void reverseAString(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            s.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        System.out.println(sb);

    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        //recursion
        int temp = s.pop();
        reverseStack(s);
        pushFromBottom(s, temp);
    }

    public static void stocksSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i < stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void findNextGreater(int ary[], int nextGreater[]){//O(n)
        Stack<Integer> s = new Stack<>();

        for(int i = ary.length - 1; i >= 0; i--){
            //1 while
            while(!s.isEmpty() && ary[s.peek()] <= ary[i]){
                s.pop();
            }

            // 2 if-else
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = ary[s.peek()];
            }

            //3 push
            s.push(i);
        }

        for(int i = 0; i < nextGreater.length; i++){
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();

        //Next greater right
        //Next greater left         Inverse the for loop (run it from 0 to ary.length)
        //Next smallest right       Inverse the while loop condition to {!s.isEmpty() && ary[s.peek()] <= ary[i]}
        //Next smallest left        Inverse the for loop (run it from 0 to ary.length), Inverse the while loop condition to {!s.isEmpty() && ary[s.peek()] <= ary[i]}

    }

    public static boolean validParentheses(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            //opening case
            if(ch == '(' || ch == '[' || ch == '{'){
                s.push(ch);
            }else{//Closing case
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')') 
                    || (s.peek() == '{' && ch == '}') 
                    || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }

        if(s.isEmpty() == false){
            return false;
        }
        return true;
    }

    public static boolean duplicateParentheses(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            //closing parentheses
            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count >= 1){
                    s.pop();
                    // continue;
                }else{
                    return true;
                }
            }

            //opening parentheses
            if(ch != ')'){
                s.push(ch);
            }
        }

        return false;
    }
    

    public static void nextSmallerRight(int heights[], int nextSmallerRight[]){
        Stack<Integer> s = new Stack<>();

        for(int i = heights.length; i >= 0; i--){

            //while
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }

            //if else
            if(!s.isEmpty()){
                nextSmallerRight[i] = i;
            }else{
                nextSmallerRight[i] = i;
            }

            //push
            s.push(i);
        }
    }

    public static void nextSmallerLeft(int heights[], int nextSmallerLeft[]){
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i <= heights.length; i++){

            //while
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }

            //if else
            if(!s.isEmpty()){
                nextSmallerLeft[i] = i;
            }else{
                nextSmallerLeft[i] = i;
            }

            //push
            s.push(i);
        }
    }

    public static int maxAreaHistogram(int heights[], int nextSmallerLeft[], int nextSmallerRight[]){

        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            int j = nextSmallerLeft[i];
            int k = nextSmallerRight[i];

            int width = j - k - 1;

            //area
            int area = heights[i] * width;
            if(maxArea < area){
                maxArea = area;
            }

        }

        return maxArea;

    }

    public static boolean isPalindrome(Node head){
        boolean isPalindrome = true;
        Stack<Integer> s = new Stack<>();
        Node slow = head;

        //filled the stack
        while(slow != null){
            s.push(slow.data);
            slow = slow.next;
        }

        Node chk = head;

        while(!s.isEmpty() && chk != null){
            if(s.peek() == chk.data){
                // continue;
            }else{
                return false;
            }
            s.pop();
            chk = chk.next;
        }

        return isPalindrome;

    }
    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(4);
        // s.push(3);
        // s.push(2);
        // s.push(1);
        // s.push(5);
        // pushFromBottom(s, 6);
        // while(!s.isEmpty()){
        //     System.out.print(s.peek() + " ");
        //     s.pop();
        // }
        // System.out.println();


        //Reverse a string using stack 
        // reverseAString("abc");


        //Reverse a STACK
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // while(!s.isEmpty()){
        //     System.out.print(s.peek() + " ");
        //     s.pop();
        // }


        //Stock Spaning Problem
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stocksSpan(stocks, span);
        // for(int i = 0; i < span.length; i++){
        //     System.out.print(span[i] + " ");
        // }
        // System.out.println();


        //Next Greater
        // int ary[] = {6, 8, 0, 1, 3};
        // int nextGreater[] = new int[ary.length];
        // findNextGreater(ary, nextGreater);

        //Valid Parentheses
        // System.out.println(validParentheses("{(})}"));

        //Duplicate Parentheses
        // System.out.println(duplicateParentheses("(((a+(b)))+(c+d))"));  //true
        // System.out.println(duplicateParentheses("((a+b)+(c+d))"));      //false


        //Max Area in Histogram
        // int heights[] = {2, 1, 5, 6, 2, 3};
        // int nextSmallerRight[] = new int[heights.length];
        // int nextSmallerLeft[] = new int[heights.length];
        // nextSmallerLeft(heights, nextSmallerLeft);
        // nextSmallerRight(heights, nextSmallerRight);
        // System.out.println(maxAreaHistogram(heights, nextSmallerLeft, nextSmallerRight));

        //Finding palindrome in Linked List using stacks
        // Node one = new Node(1);
        // Node two = new Node(2);
        // Node three = new Node(3);
        // Node four = new Node(4);
        // Node five = new Node(5);
        // one.next = two;
        // two.next = three;
        // three.next = four;
        // four.next = five;
        // System.out.println(isPalindrome(one));

    }
}

class Node{
    int data;
    Node next;
    Node(int d){
        next = null;
        data = d;
    }
}