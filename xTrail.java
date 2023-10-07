import java.util.Stack;

public class xTrail {
    public static int findDifference(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 2, 9, 1, 7, 4, 6}; // Fixed array
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        for(int i = 0; ; i++){
            if(s.isEmpty()){
                break;
            }
            System.out.println(s.pop());
        }
    }
}
