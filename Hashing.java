import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hashing {
    public static void main(String[] args) {
        // Small code of HashMaps



        // LinkedHashMaps
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("America", 50);

        System.out.println(lhm);


        // TreeMap
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("USA", 50);
        tm.put("China", 150);

        System.out.println(tm);


        // HashSet
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(4);
        hs.add(2);
        hs.add(1);

        System.out.println(hs);

        // hs.remove(2);
        // if(hs.contains(2)){
        //     System.out.println("contains");
        // } else {
        //     System.out.println("not contains");
        // }

        hs.clear();
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());

        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Mumbai");
        cities.add("Pune");

        // Iterator i = cities.iterator();
        // while(i.hasNext()){
        //     System.out.print(i.next() + " ");
        // }
        // System.out.println();

        for (String city : cities) {
            System.out.print(city + " "); 
        }
        System.out.println();


        // Linked HashSets - Maintains order
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Bangalore");
        lhs.add("Mumbai");
        lhs.add("Pune");

        for (String c : lhs) {
            System.out.print(c + " ");
        }
        System.out.println();


        // TreeSet - Ascending order
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Bangalore");
        ts.add("Pune");

        System.out.println(ts);
    }
}
