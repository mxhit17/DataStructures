public class TrieImpNProblems {
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;
        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { // O(L) - L = Length of largest string
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    public static boolean search(String key) {  // O(L) 
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.endOfWord;
    }

    public static boolean wordBreak(String key){ // O(L)
        if(key.length() == 0){
            return true;
        }

        for(int i = 1; i <= key.length(); i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }

        return false;
    }

    public static boolean startsWith(String prefix){ // O(Prefix.length)
        Node curr = root;

        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static int countUniqueSubstrings(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null){
                count += countUniqueSubstrings(root.children[i]);
            }
        }

        return count + 1;
    }

    // public static String longWordwAllPrefixes(Node root, String ans){
        

    //     for(int i = 0; i < 26; i++){
    //         // int idx = i + 'a';
    //         if(root.children[i] != null){
    //             if(!root.endOfWord){
    //                 return null;
    //             }
    //         }
    //     }
    // }
    public static void main(String[] args) {
        // Creating a trie
        // String words[] = {"the", "a", "there", "thier", "any", "thee"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }


        // Word Break Problem
        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // String key = "ilikesamsung";
        // for(int i = 0; i < words.length; i++){
        //     insert(words[i]);
        // }
        // System.out.println(wordBreak(key));


        // startsWith Problem
        // String words[] = {"apple", "app", "mango", "man", "woman"};
        // String prefix = "app";
        // for(int i = 0; i < words.length; i++){
        //     insert(words[i]);
        // }
        // System.out.println(startsWith(prefix));


        // Count Unique Substring Problem
        // String str = "apple";
        // // creating all the suffixes & inserting them into trie
        // for(int i = 0; i < str.length(); i++){
        //     String temp = str.substring(i);
        //     insert(temp);
        // }
        // System.out.println(countUniqueSubstrings(root));


        // Longest Word with all prefix
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }







    }
}
