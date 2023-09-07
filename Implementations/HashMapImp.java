import java.util.ArrayList;
// import java.util.HashMap;
import java.util.LinkedList;

public class HashMapImp {
    static class HashMap<K, V> { // k, v are generics in java
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // N
        private int N;
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < 4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i = 0; i < ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldbuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = N * 2;

            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            // nodes - add in new bucket;
            for(int i = 0; i < oldbuck.length; i++){
                LinkedList<Node> ll = oldbuck[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){ //O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key , bi); //valid or -1

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n / N;

            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){ //O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key , bi); //valid or -1

            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){ // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key , bi); //valid or -1

            if(di != -1){
                return buckets[bi].get(di).value;
            }else{
                return null;
            }
        }

        public V remove(K key){ // O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key , bi); //valid or -1

            if(di != -1){
                n--;
                return buckets[bi].remove(di).value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keyS = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keyS.add(node.key);
                }
            }

            return keyS;
        }

        public boolean isEmpty(){
            return n == 0;
        }

    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("USA", 50);
        hm.put("China", 200);
        hm.put("Nepal", 5);



        ArrayList<String> keys = hm.keySet();
        for(int i = 0; i < keys.size(); i++){
            System.out.print(keys.get(i) + " ");
        }
    }
}
