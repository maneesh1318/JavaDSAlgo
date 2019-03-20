package com.practice.tree;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 17/6/18.
 */
public class BST {
    public static void main(String agrs[]){
        BinarySearchTree T = new BinarySearchTree();
        T.insert(11);
        T.insert(2);
        T.insert(29);
        T.insert(1);
        T.insert(7);
        T.insert(15);
        T.insert(40);
        T.insert(35);
        //T.traversePreorder();
        T.traverseInorder();
        //T.traversePostorder();
        T.modify();
        //T.traversePreorder();
        T.traverseInorder();
        //T.traversePostorder();
    }
}

class TreeNode<T>{
    T elm;
    TreeNode left;
    TreeNode right;

    TreeNode(){
        this.elm = null;
        this.left = null;
        this.right = null;
    }

    TreeNode(T elm){
        this.elm = elm;
        this.left = null;
        this.right = null;
    }

}

class BinarySearchTree{
    TreeNode<Integer> root;
    static int sum = 0;

    BinarySearchTree(){
        root = null;
    }

    public void insert(Integer elm){
        root = insertRecursive(root,elm);
    }

    private TreeNode<Integer> insertRecursive(TreeNode<Integer> T,Integer elm){
        if(T == null)
            return new TreeNode(elm);
        else if(T.elm < elm) {
            T.right = insertRecursive(T.right, elm);
            return T;
        }
        else{
            T.left = insertRecursive(T.left,elm);
            return T;
        }
    }

    private void inorder(TreeNode<Integer> T){
        if(T == null) return;
        inorder(T.left);
        System.out.print(T.elm + " ");
        inorder(T.right);

    }

    private void preorder(TreeNode<Integer> T){
        if(T == null) return;
        System.out.print(T.elm + " ");
        preorder(T.left);
        preorder(T.right);

    }

    private void postorder(TreeNode<Integer> T){
        if(T == null) return;
        postorder(T.left);
        postorder(T.right);
        System.out.print(T.elm + " ");
    }

    public void traversePreorder(){
        preorder(root);
        System.out.println();
    }

    public void traverseInorder(){
        inorder(root);
        System.out.println();
    }

    public void traversePostorder(){
        postorder(root);
        System.out.println();
    }

    private void reverseInorder(TreeNode<Integer> T){
        if(T == null) return;
        reverseInorder(T.right);
        int temp = T.elm;
        T.elm = sum;
        sum += temp;
        reverseInorder(T.left);
    }

    public void modify(){
        reverseInorder(root);
    }


}
