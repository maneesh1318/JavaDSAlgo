package com.practice.tree;

class Tree{
    public char data;
    public int data2;
    public Tree left;
    public Tree right;
    Tree(char data){
        this.data = data;
        left = right = null;
    }

    Tree(int data){
        this.data2= data;
        left = right = null;
    }
}


public class TreeProblems {
    public static void main(String args[]){
        //String preorder = "FDABMHWTX";
        //String inorder =  "ADBFHMTWX";
        String postorder = "STRPQDNOMBCA";
        String preorder = "ABDPRSTQMNOC";
        String inorder =  "SRTPDQBNMOAC";
        Tree T = makeTree(preorder,inorder);
        //zigZagTraversal(T);
        //TreeData t = largestBST(T);
        //  System.out.println(t.size);
        printNodeAtDistanceK(T,'D',3);
    }

    public static void printNodeAtDistanceKDown(Tree T, int k){
        if(T == null || k < 0) return;
        if(k == 0){
            System.out.print(T.data + " ");
            return;
        }
        printNodeAtDistanceKDown(T.left,k-1);
        printNodeAtDistanceKDown(T.right,k-1);
    }


    public static int printNodeAtDistanceK(Tree T,char c,int k){
        if( T == null) return -1;
        if(T.data == c){
            printNodeAtDistanceKDown(T,k);
            return 0;
        }
        int dl = printNodeAtDistanceK(T.left,c,k);
        if(dl != -1){
            if(dl + 1 == k){
                System.out.print(T.data + " ");
            }
            else{
                printNodeAtDistanceKDown(T.right,k - dl - 2);
            }
            return dl + 1;
        }
        int dr = printNodeAtDistanceK(T.right,c,k);
        if(dr != -1){
            if(dr + 1 == k){
                System.out.print(T.data + " ");
            }
            else {
                printNodeAtDistanceKDown(T.left,k - dr - 2);
            }
            return dr + 1;
        }
        return -1;
    }

    public static TreeData largestBST(Tree T){
        if(T == null){
            return new TreeData();
        }
        TreeData t1 = largestBST(T.left);
        TreeData t2 = largestBST(T.right);
        if(t1.isBST && t2.isBST){
            if(T.data > t1.max && T.data < t2.min){
                TreeData t = new TreeData();
                t.isBST = true;
                t.size = t1.size + t2.size + 1;
                t.min = (T.left != null)? t1.min : T.data;
                t.max = (T.right != null)? t2.max: T.data;
                return t;
            }
        }
        TreeData t = new TreeData();
        t.isBST = false;
        t.size = Math.max(t1.size,t2.size);
        return t;
    }

    public static void zigZagTraversal(Tree T){
        for(int i =0;i<height(T);i++){
            printLevel(T,i,(i%2));
            System.out.println();
        }
    }

    public static void printLevel(Tree T,int level,int order){
        if(T == null) return;
        if(level <= 0){
            System.out.print(T.data + " ");
            return;
        }
        printLevel((order == 0)?T.left:T.right,level - 1,order);
        printLevel((order == 0)?T.right:T.left,level - 1,order);
    }


    public static int height(Tree T){
        if(T == null) return 0;
        return 1 + Math.max(height(T.left),height(T.right));
    }

    public static Tree makeTree(String preorder,String inorder){
        if(inorder.isEmpty()) return null;
        if(inorder.length() == 1) return new Tree(inorder.charAt(0));
        int root = searchRoot(inorder,preorder);
        Tree T = new Tree(inorder.charAt(root));
        T.left = makeTree(preorder,inorder.substring(0,root));
        T.right = makeTree(preorder,inorder.substring(root+1));
        return T;
    }

    public static int searchRoot(String inorder,String preorder){
        int minIndex = preorder.length();
        int inIndex = -1;
        for(int i = 0;i<inorder.length();i++){
            if(minIndex > preorder.indexOf(inorder.charAt(i))){
                minIndex = preorder.indexOf(inorder.charAt(i));
                inIndex = i;
            }
        }
        return inIndex;
    }

    public static void inorder(Tree T){
        if(T == null) return;
        inorder(T.left);
        System.out.print(T.data);
        inorder(T.right);
    }

    public static void preorder(Tree T){
        if(T == null) return;
        System.out.print(T.data);
        preorder(T.left);
        preorder(T.right);
    }

    public static void postorder(Tree T){
        if(T == null) return;
        postorder(T.left);
        postorder(T.right);
        System.out.print(T.data);
    }
}

class TreeData{
    public boolean isBST;
    public char max;
    public char min;
    public int size;

    TreeData(){
        isBST = true;
        size = 0;
        max = Character.MIN_VALUE;
        min = Character.MAX_VALUE;
    }
}


