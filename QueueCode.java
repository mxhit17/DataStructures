import java.util.*;
import java.util.LinkedList;
public class QueueCode {
    public static void printNonRepeating(String str){

        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.println("-1");
            }else{
                System.out.println(q.peek());
            }
        }
    }

    public static void interleaveQueue(Queue<Integer> q) {
        Queue<Integer> leftQ = new LinkedList<>();
        Queue<Integer> rightQ = new LinkedList<>();

        int size = q.size();
        int half = size / 2;

        // Left half ready
        for (int i = 0; i < half; i++) {
            leftQ.add(q.peek());
            q.remove();
        }

        // Right queue ready
        while (!q.isEmpty()) {
            rightQ.add(q.peek());
            q.remove();
        }

        // Interleaving the og queue
        while (!leftQ.isEmpty() && !rightQ.isEmpty()) {
            q.add(leftQ.remove());
            q.add(rightQ.remove());
        }

        // If there are any remaining elements in leftQ or rightQ, add them to q
        while (!leftQ.isEmpty()) {
            q.add(leftQ.remove());
        }

        while (!rightQ.isEmpty()) {
            q.add(rightQ.remove());
        }
    }

    public static void queueReversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    
    public static void main(String[] args) {
        // String str = "aabccxb";
        // printNonRepeating(str);


        //Interleaving two halves of a queue
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        //
        // interleaveQueue(q);
        //  
        // while (!q.isEmpty()) {
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }
        // System.out.println();


        //Queue Reversal
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);

        // queueReversal(q);

        // while(!q.isEmpty()){
        //     System.out.print(q.peek() + " ");
        //     q.remove();
        // }
        // System.out.println();
    }
}
