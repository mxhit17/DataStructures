public class TriePrefixProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans){  // O(L) - L = Longest word int trie
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i = 0; i < root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }

    }
    public static void main(String[] args) {
        // Prefix Problem
        String ary[] = {"zebra", "dog", "duck", "dove"};
        for(int i = 0; i < ary.length; i++){
            insert(ary[i]);
        }
        root.freq = -1;
        findPrefix(root, "");


    }
}
