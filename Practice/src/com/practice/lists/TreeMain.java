package com.practice.lists;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 27/5/18.
 */
public class TreeMain {
    public static void main(String args[]){
        String preorder = "FBADCEGIH";
        String inorder = "ABCDEFGHI";
        String postorder = "ACEDBHIGF";
        Tree T = new Tree();
        //T.makeTreeInorderPreorder(inorder,preorder);
        T.makeTreeInorderPostorder(inorder,postorder);
        T.traverInorder();
        T.traverPreorder();
        T.traverPostorder();
    }
}

class Tree{
    static final int INFINITY = 1000;
    TreeNode<Character> root;
    Tree(){
        root = null;
    }

    private TreeNode<Character> makeTree1(String inorder,String preorder){
        if(inorder =="") return null;
        if(inorder.length() == 1){
            TreeNode<Character> t = new TreeNode<>(inorder.charAt(0));
            return t;
        }
        int index= INFINITY;
        int elm = 0;
        for(int i =0;i<inorder.length();i++){
            if(preorder.indexOf(inorder.charAt(i)) < index){
                index = preorder.indexOf(inorder.charAt(i));
                elm = i;
            }
        }
        String s1 = (elm > 0)?inorder.substring(0,elm):"";
        String s2 = (elm < inorder.length() - 1)?inorder.substring(elm+1):"";
        TreeNode<Character> t = new TreeNode<>(inorder.charAt(elm));
        t.setLeft(makeTree1(s1,preorder));
        t.setRight(makeTree1(s2,preorder));
        return t;
    }

    private TreeNode<Character> makeTree2(String inorder, String postorder){
        if(inorder =="") return null;
        if(inorder.length() == 1){
            TreeNode<Character> t = new TreeNode<>(inorder.charAt(0));
            return t;
        }
        int index= -1;
        int elm = 0;
        for(int i =0;i<inorder.length();i++){
            if(postorder.indexOf(inorder.charAt(i)) > index){
                index = postorder.indexOf(inorder.charAt(i));
                elm = i;
            }
        }
        String s1 = (elm > 0)?inorder.substring(0,elm):"";
        String s2 = (elm < inorder.length() - 1)?inorder.substring(elm+1):"";
        TreeNode<Character> t = new TreeNode<>(inorder.charAt(elm));
        t.setLeft(makeTree1(s1,postorder));
        t.setRight(makeTree1(s2,postorder));
        return t;
    }

    public void makeTreeInorderPreorder(String inorder,String preorder){
        root =  makeTree1(inorder,preorder);
        return;
    }

    public void makeTreeInorderPostorder(String inorder, String postorder){
        root = makeTree2(inorder,postorder);
        return;
    }

    private void inorder(TreeNode<Character> T){
        if(T == null) return;
        inorder(T.getLeft());
        System.out.print(T.getElm() + " ");
        inorder(T.getRight());

    }

    private void preorder(TreeNode<Character> T){
        if(T == null) return;
        System.out.print(T.getElm() + " ");
        preorder(T.getLeft());
        preorder(T.getRight());

    }

    private void postorder(TreeNode<Character> T){
        if(T == null) return;
        postorder(T.getLeft());
        postorder(T.getRight());
        System.out.print(T.getElm() + " ");
    }

    public void traverPreorder(){
        preorder(root);
        System.out.println();
    }

    public void traverInorder(){
        inorder(root);
        System.out.println();
    }

    public void traverPostorder(){
        postorder(root);
        System.out.println();
    }


}

class TreeNode<T>{
    private T elm;
    private TreeNode<T> left;
    private TreeNode<T> right;

    TreeNode(T elm){
        this.elm = elm;
        this.left = null;
        this.right = null;
    }

    public TreeNode<T> getLeft(){
        return this.left;
    }

    public void setLeft(TreeNode<T> t){
        this.left = t;
    }

    public TreeNode<T> getRight(){
        return this.right;
    }

    public void setRight(TreeNode<T> t){
        this.right = t;
    }

    public T getElm(){
        return this.elm;
    }

    public void setElm(T elm){
        this.elm = elm;
    }

}
