public class xTrail {

    public static void bubbleSort(int ary[]){
        for(int i = 0; i < ary.length; i++){
            for(int j = 0; j < ary.length - i - 1; j++){
                if(ary[j] > ary[j + 1]){
                    int temp = ary[j];
                    ary[j] = ary[j + 1];
                    ary[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int ary[] = {6, 0, 3, 5};
        bubbleSort(ary);
        for(int i = 0; i < ary.length; i++){
            System.out.print(ary[i] + " ");
        }
    }
}