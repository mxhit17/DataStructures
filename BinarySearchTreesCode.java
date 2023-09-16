import java.util.Collections;
import java.util.*;

public class BinarySearchTreesCode {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(int val, Node root){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(val < root.data){
            //left subtree
            root.left = insert(val, root.left);
        }else{
            //right subtree
            root.right = insert(val, root.right);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node searchBST(Node root, int key){
        if(root == null){
            return null;
        }

        if(root.data == key){
            return root;
        }else if(key < root.data){
            return searchBST(root.left, key);
        }else{
            return searchBST(root.right, key);
        }
    }

    public static boolean searchBST2(Node root, int key){ //Same funtion as above in boolean form
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }else if(key < root.data){
            return searchBST2(root.left, key);
        }else{
            return searchBST2(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{//voila
            //case 1 - leaf node
            if(root.right == null && root.left == null){
                return null;
            }
            //case 2 - one child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //case 3 - two childs
            Node is = findInoderSuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }

    public static Node findInoderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        printInRange(root.left, k1, k2);
        if(k1 <= root.data && root.data <= k2){
            System.out.print(root.data + " ");
        }
        printInRange(root.right, k1, k2);
    }

    public static void printArrayList(ArrayList<Integer> a){
        for(int i = 0; i < a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.right == null && root.left == null){
            printArrayList(path);
        }

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);
        path.remove(path.size() - 1);

        return;
    }

    public static boolean isValid(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }

        boolean left = isValid(root.left, min, root);
        boolean right = isValid(root.right, root, max);

        return left && right;
    }

    public static void mirror(Node root){
        if(root == null){
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);

        return;
    }
    
    public static Node buildBST(int ary[], int si, int ei){
        if(si > ei){
            return null;
        }

        int mid = si + (ei - si) / 2;

        Node root = new Node(ary[mid]);

        root.left = buildBST(ary, si, mid - 1);
        root.right = buildBST(ary, mid + 1, ei);

        return root;

    }

    public static void inorderArrayList(Node root, ArrayList<Integer> bst1){
        if(root == null){
            return;
        }

        inorderArrayList(root.left, bst1);
        bst1.add(root.data);
        inorderArrayList(root.right, bst1);

        return;
    }

    public static void sortArraylist(ArrayList<Integer> tree1, ArrayList<Integer> tree2, ArrayList<Integer> finalTree){
        for(int i = 0; i < tree1.size(); i++){
            int temp = tree1.remove(i);
            finalTree.add(temp);
        }

        for(int i = 0; i < tree1.size(); i++){
            int temp = tree2.remove(i);
            finalTree.add(temp);
        }

        Collections.sort(finalTree);
    }

    public static void main(String[] args) {
        // int values[] = {5, 1, 3, 4, 2, 7};
        // int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        int values[] = {1, 2, 4}; // bst1
        Node bst2 = new Node(9); // bst2
        bst2.left = new Node(3);
        bst2.right = new Node(12);
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = insert(values[i], root);
        }

        //Inorder Traversal
        // inorder(root);
        // System.out.println();


        //Searching is a BST
        // System.out.println(searchBST(root, 7).data);
        // System.out.println(searchBST2(root, 5));


        //Deleting Node in a BST
        // delete(root, 3);
        // inorder(root);


        //Printing in a range
        // printInRange(root, 2, 5);


        //Root to Leaf Path
        // ArrayList<Integer> path = new ArrayList<>();
        // rootToLeaf(root, path);


        //Validate a BST
        // System.out.println(isValid(root, null, null));


        // Mirror a BST
        // mirror(root);
        // inorder(root);


        //Sorted Array to a Balanced BST
        // int ary[] = {3, 5, 6, 8, 10, 11, 12};
        // Node root = buildBST(ary, 0, ary.length - 1);
        // inorder(root);


        // Create a Balanced BST from a BST
        // Very Easy


        //Size of the largest BST in Binary Tree




        //Merge 2 BST
        // ArrayList<Integer> tree1 = new ArrayList<>();
        // ArrayList<Integer> tree2 = new ArrayList<>();
        // inorderArrayList(root, tree1);
        // inorderArrayList(bst2, tree2);

        // ArrayList<Integer> finalTree = new ArrayList<>();
        // sortArraylist(tree1, tree2, finalTree);
        // int finalValues[] = new int[finalTree.size()];
        // for(int i = 0; i < finalTree.size(); i++){
        //     finalValues[i] = finalTree.remove(i);
        // }

        // Node ha = buildBST(finalValues, 0, finalValues.length - 1);
        // System.out.println(ha.data);


        

    }
}
