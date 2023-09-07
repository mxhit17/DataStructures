class Solution
{
    static int idx(int ary[]){
        for(int i = 0; i < ary.length; i++){
            int temp = ary[i] % 2;
            int chkOdd = ary[i] / 2;
            if(temp == 0 && chkOdd % 2 == 1){
                return i;
            }
        }

        for(int i = 0; i < ary.length; i++){
            int temp = ary[i] % 2;
            if(temp == 0){
                return i;
            }
        }

        return -1;
    }
    int count = 0;

    static int sum(int ary[]){
        int sum = 0;
        for(int i = 0; i < ary.length; i++){
            sum += ary[i];
        }
        return sum;
    }

    static int findMin(int ary[], int n)
    {
        
        int count = 0;
        if(sum(ary) % 2 == 0){
            return 0;
        }else{
            while(sum(ary) % 2 != 0){
                int temp = idx(ary);
                if(temp == -1){
                    return -1;
                }
                ary[temp] = ary[temp] / 2;
                count++;
            }
        }

        return count;
    }
}