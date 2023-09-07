import java.util.*;
import java.util.LinkedList;

public class BinaryTreeCode {
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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrderTraversal(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);

        }

        public static void inOrderTraversal(Node root){
            if(root == null){
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root){
            if(root == null){
                return;
            }

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty()){  
                Node curr = q.remove();
                if(curr != null){
                    System.out.print(curr.data + " ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }else if(curr == null){//curr == null
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
            }

        }

        public static int maxHeight(Node root){
            if(root == null){
                return 0;
            }
    
            int lh = maxHeight(root.left);
            int rh = maxHeight(root.right);
    
            int height = Math.max(lh, rh) + 1;
    
            return height;
        }

        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }

            int ln = countNodes(root.left);
            int rn = countNodes(root.right);

            int count = ln + rn + 1;

            return count;
        }

        public static int sumNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);

            int treeSum = leftSum + rightSum + root.data;

            return treeSum;
        }

        public static int diameter2(Node root){
            //base case
            if(root == null){
                return 0;
            }
    
            int ldia = diameter2(root.left);
            int lh = maxHeight(root.left);
            int rdia = diameter2(root.right);
            int rh = maxHeight(root.right);

            int selfDia = lh + rh + 1;
    
            return Math.max(selfDia, Math.max(rdia, ldia));
        }

        static class Info{
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter(Node root){
            if(root == null){
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info righInfo = diameter(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.ht + righInfo.ht + 1);
            int ht = Math.max(righInfo.ht, leftInfo.ht) + 1;

            return new Info(diam, ht);
        }

        public static boolean isIdentical(Node node, Node subroot){
            if(node == null && subroot == null){
                return true;
            }else if(node == null || subroot == null){
                return false;
            }else if(node.data != subroot.data){
                return false;
            }

            if(!isIdentical(node.left, subroot.left)){
                return false;
            }
            if(!isIdentical(node.right, subroot.right)){
                return false;
            }

            return true;
        }

        public static boolean isSubtree(Node root, Node subroot){
            if(root == null){
                return false;
            }

            if(root.data == subroot.data){
                if(isIdentical(root, subroot)){
                    return true;
                }
            }

            return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
        }

        public static void kthLevel(Node root, int k){
            if(root == null){
                return;
            }

            if(k == 1){
                System.out.print(root.data + " ");
                // return;
            }else if(k > 1){
                kthLevel(root.left, k - 1);
                kthLevel(root.right, k - 1);
            }
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }

            path.add(root);

            if(root.data == n){
                return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if(foundLeft || foundRight){
                return true;
            }

            path.remove(path.size() - 1);

            return false;
        }

        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            for(; i < path1.size() && i < path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }

            Node lca = path1.get(i - 1);
            return lca;
        }

        public static Node lca2(Node root, int n1, int n2){
            if(root == null){ 
                return null;
            }
            
            if(root.data == n1 || root.data == n2){
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }
            return root;
        }

        public static int distance(Node root, int n){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int left = distance(root.left, n);
            int right = distance(root.right, n);

            if(left == -1 && right == -1){
                return -1;
            }else if(right == -1){
                return left + 1;
            }else{
                return right + 1;
            }
        }

        public static int kthAnc(Node root, int n, int k){
            if(root == null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }

            int left = kthAnc(root.left, n, k);
            int right = kthAnc(root.right, n, k);

            if(left == -1 && right == -1){
                return -1;
            }

            int max = Math.max(left, right);
            if(max + 1 == k){
                System.out.println(root.data);
            }
            
            return max + 1;
        }

        public static Node sumTree(Node root){
            if(root == null){
                return null;
            }
        
            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);

            root.data = leftSum + rightSum;

            sumTree(root.left);
            sumTree(root.right);

            return root;

        }
    }

    public static void main(String[] args) {
        //Building a Binary Tree
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);


        //Pre Order Sequence
        // tree.preOrderTraversal(root);

        //InOrder Sequence
        // tree.inOrderTraversal(root);

        //PostOrder Sequence
        // tree.postOrderTraversal(root);

        //LevelOrder Sequence
        // tree.levelOrder(root);


        //Max Height of a Binary Tree
        // System.out.println(tree.maxHeight(root));

        //Count Nodes in a  Binary Tree
        // System.out.println(tree.countNodes(root));

        //Count Sum of data in Nodes in a Binary Tree
        // System.out.println(tree.sumNodes(root));

        //Diameter of a Binary Tree
        // System.out.println(tree.diameter2(root));
        // System.out.println(tree.diameter(root).diam);


        //Subtree of another tree
        // Node subroot = new Node(2);
        // subroot.left = new Node(4);
        // subroot.right = new Node(5);
        // System.out.println(tree.isSubtree(root, subroot));


        //Kth Level of a tree  
        // tree.kthLevel(root, 3);


        //Lowest Common Ancestor
        // System.out.println(tree.lca(root, 4, 5).data);       //Approach 1
        // System.out.println(tree.lca2(root, 4, 5).data);      //Approach 2

        //Minimum distance of two nodes
        // int n1 = 4, n2 = 6;
        // Node lca = tree.lca2(root, n1, n2);
        // System.out.println(tree.distance(lca, n1) + tree.distance(lca, n2));


        //Kth Ancestor of a Node
        // tree.kthAnc(root, 5, 2);


        //Transform to sum tree
        // System.out.println(tree.sumTree(root).data);
    }
}