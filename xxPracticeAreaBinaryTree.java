import java.util.*;
import java.util.LinkedList;

public class xxPracticeAreaBinaryTree {
    static class Node {
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
        public static Node buildTree(int order[]){
            idx++;

            if(order[idx] == -1){
                return null;
            }

            Node newNode = new Node(order[idx]);
            newNode.left = buildTree(order);
            newNode.right = buildTree(order);

            return newNode;
        }

        public static void preOrder(Node root){
            if(root == null){
                // System.out.print("-1 ");
                return;
            }

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);

            return;
        }

        public static void levelOrder(Node root){
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
                }else{ // curr = null
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    }
                }
            }
        }

        public static int mxHeight(Node root){
            if(root == null){
                return 0;
            }

            int lh = mxHeight(root.left);
            int rh = mxHeight(root.right);

            int totalH = Math.max(lh, rh) + 1;

            return totalH;
        }

        public static int totalNodes(Node root){
            if(root == null){
                return 0;
            }

            int ln = totalNodes(root.left);
            int rn = totalNodes(root.right);

            int tn = ln + rn + 1;
            return tn;
        }

        static int sum = 0;
        public static int totalSum(Node root){
            if(root == null){
                return 0;
            }

            int data = root.data;

            int ldata = totalSum(root.left);
            int rdata = totalSum(root.right);

            sum = sum + data;

            return sum;
        }

        public static int dia(Node root){
            if(root == null){
                return 0;
            }

            int lfDia = dia(root.left);
            int lh = mxHeight(root.left);
            int rhDia = dia(root.right);
            int rh = mxHeight(root.right);

            int dia = lh + rh + 1;
            int diaAlt = Math.max(lfDia, rhDia);

            return Math.max(dia, diaAlt);
        }

        public static boolean isIdentical(Node root, Node subRoot){
            if(root == null && subRoot == null){
                return true;
            }
            if(root == null || subRoot == null){
                return false;
            }

            if(root.data == subRoot.data){
                return true;
            }

            boolean left = isIdentical(root.left, subRoot.left);
            boolean right = isIdentical(root.right, subRoot.right);

            return left && right;
        }

        public static void isSubtree(Node root, Node subRoot){
            if(root == null){
                return;
            }

            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    System.out.println("true");
                    return;
                }else{
                    System.out.println("false");
                    return;
                }
            }

            isSubtree(root.left, subRoot);
            isSubtree(root.right, subRoot);

            return;
        }

        public static void kthLevel(Node root, int k){
            if(root == null){
                return;
            }

            if(k == 1){
                System.out.print(root.data + " ");
                return;
            }

            kthLevel(root.left, k-1);
            kthLevel(root.right, k - 1);
        }

        public static Node lca(Node root, int n1, int n2){
            if(root == null){
                return null;
            }

            if(root.data == n1 || root.data == n2){
                return root;
            }

            Node leftLca = lca(root.left, n1, n2);
            Node rightLca = lca(root.right, n1, n2);

            if(rightLca == null){
                return leftLca;
            }
            if(leftLca == null){
                return rightLca;
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

            int dl = distance(root.left, n);
            int rl = distance(root.right, n);

            // int dis;
            if(dl == -1 && rl == -1){
                return -1;
            }
            if(dl == -1){
                return rl + 1;
            }else{
                return dl + 1;
            }
        }


        // public static int firstAncestor(Node root, int n) {
        //     if (root == null) {
        //         return -1;
        //     }
            
        //     if (root.data == n) {
        //         return -1; // We found the node we are looking for, but no ancestor in this case
        //     }
        
        //     if ((root.left != null && root.left.data == n) || (root.right != null && root.right.data == n)) {
        //         return root.data; // This node is the parent of the node we are looking for
        //     }
        
        //     int leftAncestor = firstAncestor(root.left, n);
        //     if (leftAncestor != -1) {
        //         return leftAncestor; // If ancestor found on the left subtree, return it
        //     }
        
        //     int rightAncestor = firstAncestor(root.right, n);
        //     if (rightAncestor != -1) {
        //         return rightAncestor; // If ancestor found on the right subtree, return it
        //     }
        
        //     return -1; // Node with data n is not present in this subtree
        // }

        // public static int firstAncestor2(Node root, int n){
        //     if(root == null){
        //         return -1;
        //     }
        //     if(root.left == null && root.right == null){
        //         return -1;
        //     }

        //     if(root.left.data == n){
        //         // System.out.println(root.data);
        //         return root.data;
        //     }else if(root.right.data == n){
        //         // System.out.println(root.data);
        //         return root.data;
        //     }

        //     firstAncestor2(root.left, n);
        //     firstAncestor2(root.right, n);
        //     return -1;
        // }


        // public static Node findAn(Node root, int n){
        //     if(root == null || root.data == n){
        //         return null;
        //     }

            


        // }

    
        
    }
    public static void main(String[] args) {
        int order[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(order);

        int n1 = 4;
        int n2 = 6;
        Node lca = tree.lca(root, n1, n2);

        // System.out.println(tree.firstAncestor(root, n2));



    }
}


