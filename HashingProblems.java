import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;

public class HashingProblems {
    public static ArrayList<Integer> majorityElement(int ary[], TreeMap<Integer, Integer> tm){
        for(int i = 0; i < ary.length; i++){
            if(tm.containsKey(ary[i])){
                int val = tm.get(ary[i]);
                tm.put(ary[i], val + 1);
            }else{
                tm.put(ary[i], 1);
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        int freq = ary.length / 3;

        for(int i = 0; i < ary.length; i++){
            if(tm.containsKey(ary[i])){
                if(tm.get(ary[i]) >= freq){
                    a.add(ary[i]);
                    tm.remove(ary[i]);
                }
            }
        }
        
        return a;
    }

    public static boolean validAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        HashMap<Character, Integer> s1 = new HashMap<>();
        HashMap<Character, Integer> s2 = new HashMap<>();

        for(int i = 0; i < a.length(); i++){
            s1.put(a.charAt(i), s1.getOrDefault(a.charAt(i), 0) + 1);
        }

        for(int i = 0; i < b.length(); i++){
            s2.put(b.charAt(i), s2.getOrDefault(b.charAt(i), 0) + 1);
        }

        for(int i = 0; i < a.length(); i++){
            char curr = a.charAt(i);
            if(s1.containsKey(curr) && s2.containsKey(curr)){
                if(s1.get(curr) == s2.get(curr)){
                    continue;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }

        return true;
    }

    public static int distinctElement(int nums[]){
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }

        return hs.size();
    }

    public static int union(int ary1[], int ary2[]){
        HashSet<Integer> union = new HashSet<>();
        for(int i = 0; i < ary1.length; i++){
            union.add(ary1[i]);
        }
        for(int i = 0; i < ary2.length; i++){
            union.add(ary2[i]);
        }

        return union.size();
    }

    public static int intersection(int ary1[], int ary2[]){
        HashSet<Integer> intersection = new HashSet<>();
        for(int i = 0; i < ary1.length; i++){
            intersection.add(ary1[i]);
        }

        int count = 0;

        for(int i = 0; i < ary2.length; i++){
            if(intersection.contains(ary2[i])){
                count++;
                intersection.remove(ary2[i]);
            }
        }

        return count;
    }

    public static String sp(HashMap<String, String> hm){
        HashMap<String, String> revHm = new HashMap<>();

        for (String key : hm.keySet()) {
            revHm.put(hm.get(key), key);
        }

        for (String key : hm.keySet()) {
            if(!revHm.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void itinarary(HashMap<String, String> hm, String sp){
        String temp = sp;
        for(int i = 0; i < hm.size(); i++){
            System.out.print(temp + " -> ");
            temp = hm.get(temp);
        }
        System.out.println(temp);
    }

    public static int largestSub(int ary[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;

        for(int j = 0; j < ary.length; j++){
            sum += ary[j];
            if(hm.containsKey(sum)){
                int i = hm.get(sum);
                len = Math.max(j, i);
            }else{
                hm.put(sum, j);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        // Majority Element
        // int ary[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // int ary[] = {1, 2};
        // TreeMap<Integer, Integer> tm = new TreeMap<>();
        // ArrayList<Integer> a = majorityElement(ary, tm);

        // System.out.println(a);


        // Valid Anagram
        // String a = "b";
        // String b = "d";

        // System.out.println(validAnagram(a, b));


        // HashSets
        // Count Distinct Elements
        // int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1}; // ans = 7
        // System.out.println(distinctElement(nums));


        // Union and Intersection of 2 Arrays
        // int ary1[] = {7, 3, 9};
        // int ary2[] = {6, 3, 9, 2, 9, 4};
        // System.out.println("Union : " + union(ary1, ary2) + ", Intersection : " + intersection(ary1, ary2));


        // Find Itinarary from tickets
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengalore");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");
        // String sp = sp(tickets);
        // itinarary(tickets, sp);


        // Largest Subarray with sum 0
        // int ary[] = {15, -2, 2, -8, 1, 7, 10, 23};
        // System.out.println(largestSub(ary));


        // Subarray sum equal to K
        int ary[] = {1, 2, 3};
        int K = 3;

    }
}
