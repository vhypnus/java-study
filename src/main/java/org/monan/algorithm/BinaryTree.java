package org.monan.algorithm;

public class BinaryTree {

    private static class Node {

        public int val ;

        public Node left ;

        public Node right ;

        public Node(int val) {
            this.val = val;
        }


    }

    public Node root ;

    private BinaryTree() {
    }

    public static BinaryTree newBinaryTree(){
        return new BinaryTree() ;
    }

    public void add(Node node){
        if (node == null ){
            return  ;
        }

        if (root == null ){
            root = node ;
        } else {
            Node tmp = root ;
            while(true){
                if(node.val > tmp.val){
                    if (tmp.right == null){
                        tmp.right = node ;
                        break ;
                    } else {
                        tmp = tmp.right;
                    }
                } else {
                    if (tmp.left == null){
                        tmp.left = node ;
                        break ;
                    } else{
                        tmp = tmp.left ;
                    }
                }
            }
        }
    }


    public static void preorder(Node root){
        Node r = root ;
        System.out.print(r.val+"->") ;
        if (r.left != null){
            preorder(r.left);
        }

        if(r.right != null){
            preorder(r.right);
        }

    }

    public int depth(Node root){
        Node r= root ;
        if (root== null){
            return 0 ;
        }

        int left = depth(r.left) ;
        int right = depth(r.right) ;

        return Math.max(left,right) +1 ;


    }

    public static void main(String[] args) {
        BinaryTree bst = newBinaryTree() ;
        bst.add(new Node(15));
        bst.add(new Node(2));
        bst.add(new Node(10));
        bst.add(new Node(12));
        bst.add(new Node(20));
        bst.add(new Node(30));

        preorder(bst.root);
        System.out.println() ;

        System.out.println(bst.depth(bst.root)) ;
    }
}



