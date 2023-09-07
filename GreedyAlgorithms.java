import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GreedyAlgorithms {
    public static void maximumActivity(int start[], int end[]){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        int maxActivity = 1;
        int lastEnd = end[0];
        for(int i = 1; i < start.length; i++){
            if(start[i] >= lastEnd){
                maxActivity++;
                ans.add(i);
                lastEnd = end[i];
            }else{
                continue;
            }
        }
        System.out.println("Maximum Activities : " + maxActivity);
        for(int i = 0; i < ans.size(); i++){
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void maximumActivityNotSorted(int start[], int end[]){
        //Sorting on the basis of end time
        int activities[][] = new int[start.length][3];
        for(int i = 0; i < start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        //lambda function -> short form for a function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(activities[0][0]);
        int maxActivity = 1;
        int lastEnd = activities[0][2];
        for(int i = 1; i < start.length; i++){
            if(activities[i][1] >= lastEnd){
                maxActivity++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }else{
                continue;
            }
        }
        System.out.println("Maximum Activities : " + maxActivity);
        for(int i = 0; i < ans.size(); i++){
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }

    public static void fractionalKnapsack(int weight[], int value[], int W){
        double ratio[][] = new double[value.length][2];
        //0th col => idx & 1st col => ratio
        for(int i = 0; i < value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double)weight[i];
        }
        
        //sorting according to ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int totalValue = 0;
        int capacity = W;
        for(int i = ratio.length - 1; i >= 0; i--){
            int Idx = (int)ratio[i][0];
            if(capacity >= weight[Idx]){
                totalValue += value[Idx];
                capacity -= weight[Idx];
            }else{
                //include fractional value
                totalValue += ratio[i][1] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println(totalValue);
    }

    public static int minAbsoluteDiffPairs(int A[], int B[]){
        int N = A.length;

        //sorting arrays
        Arrays.sort(A);
        Arrays.sort(B);

        int absoluteDiff = 0;

        for(int i = 0; i < N; i++){
            if((A[i] - B[i]) >= 0){
                absoluteDiff += A[i] - B[i];
            }else{
                absoluteDiff += B[i] - A[i];
            }
        }

        return absoluteDiff;
    }

    public static int chainOfPairs(int pairs[][]){
        //sorting 
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chain = 1;
        int lastBig = pairs[0][1];

        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > lastBig){
                chain++;
                lastBig = pairs[i][1];
            }
        }

        return chain;
    }

    public static int indianCoins(int denom[], int v){
        int value = v;
        int notes = 0;
        int i = denom.length-1;

        while(value != 0){
            if(denom[i] <= value){
                notes++;
                value -= denom[i];
            }
            if(denom[i] > value){
                i--;
            }
        }
        return notes;
    }

    public static void jobSequencing(int jobInfo[][]){
        //sort ary
        Arrays.sort(jobInfo, Comparator.comparingDouble(o -> o[0]));

        //store jobs
        ArrayList<Integer> jobs = new ArrayList<>();

        int profit = jobInfo[0][1];
        
        for(int i = 1; i < jobInfo.length; i++){
            if(jobInfo[i][0] > jobInfo[i-1][0]){
                profit += jobInfo[i][1];
                jobs.add(i);
            }else if(jobInfo[i][0] == jobInfo[i-1][0]){
                if(jobInfo[i][1] > jobInfo[i-1][1]){
                    int tempPro = jobInfo[i][1] - jobInfo[i-1][1];
                    profit += tempPro;
                    jobs.add(i);
                }
            }
        }

        System.out.println("Max Profit : " + profit);
        System.out.print("Job Numbers : ");
        for(int i = 0; i < jobs.size(); i++){
            System.out.print(jobs.get(i) + " ");
        }
        System.out.println();
        System.out.println("Max Jobs : " + jobs.size());
    }

    public static int chocolaProblem(Integer costVer[], Integer costHor[], int n, int m){
        //sorting in desending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;


        while(h < costHor.length && v < costVer.length){
            //vertical cost < horizontal cost
            if(costVer[v] <= costHor[h]){//horzontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }else{//vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length){//for remaining horizontal cuts if any 
            cost += (costHor[h] * vp);
            hp++;
            h++;
            
        }

        while(v < costVer.length){//for remaining vertical cuts if any 
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        return cost;

    }
    public static void main(String[] args) {
        // Activity Selection
        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};
        // maximumActivity(start, end);
        // maximumActivityNotSorted(start, end);


        // Fractinal Knapsack
        // int W = 50;
        // int weight[] = {10, 20, 30};
        // int value[] = {60, 100, 120};
        // fractionalKnapsack(weight, value, W);

        
        //Minimum Absolute difference pairs
        // int A[] = {1, 2, 3};
        // int B[] = {2, 1, 3};
        // System.out.println(minAbsoluteDiffPairs(A, B));


        // Max Length Chain of Pairs
        // int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        // System.out.println(chainOfPairs(pairs));


        //Indian Coins
        // int denomination[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        // int v = 121;
        // System.out.println(indianCoins(denomination, v));


        //Job Sequencing Problem
        // int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        // jobSequencing(jobInfo);


        //Chocola Problem Code
        // int n = 4; int m = 6;
        // Integer costVer[] = {2, 1, 3, 1, 4}; //m-1
        // Integer costHor[] = {4, 1, 2}; // n-1
        // System.out.println(chocolaProblem(costVer, costHor, n, m));
    }
}
