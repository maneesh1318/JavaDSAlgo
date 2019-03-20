package com.practice.tree;

public class TrieTreeMain {
    public static void main(String args[]){
        TrieTree T = new TrieTree();
        T.insert("manish");
        T.insert("man");
        T.insert("abcd");
        T.insert("xyz");
        T.insert("manner");
        T.insert("genere");
        T.insert("tom");
        T.print();
        System.out.println("***********");
        T.delete("tom");
        T.delete("man");
        T.print();
        System.out.println("***********");
        if(T.search("manish")) System.out.println("FOUND");
        if(T.search("woman")) System.out.println("FOUND");

    }
}

class TrieTreeNode{
    TrieTreeNode[] trieTreeNodes;
    boolean flag;

    TrieTreeNode(){
        trieTreeNodes = new TrieTreeNode[26];
        flag = false;
    }
}

class TrieTree{

    TrieTreeNode root;

    TrieTree(){
        root = new TrieTreeNode();
    }


    public void insert(String str){
        root = insertRecursive(root,str);

    }

    private  TrieTreeNode insertRecursive(TrieTreeNode t,String str){
        if(t == null) t = new TrieTreeNode();
        if(str.isEmpty()) t.flag = true;
        else{
            synchronized (t) {
                char c = str.charAt(0);
                t.trieTreeNodes[c - 'a'] = insertRecursive(t.trieTreeNodes[c - 'a'], str.substring(1));
            }
        }
        return t;
    }

    public void delete(String str){
        deleteRecursive(root,str);
    }

    private void deleteRecursive(TrieTreeNode t,String str){
        if(t == null) return;
        if(str.isEmpty()) {
            t.flag = false;
            return;
        }
        char c = str.charAt(0);
        deleteRecursive(t.trieTreeNodes[c - 'a'],str.substring(1));
    }

    public boolean search(String str){
        return searchRecursive(root,str);
    }

    private boolean searchRecursive(TrieTreeNode t,String str){
        if(t == null)
            return false;
        if(str.isEmpty()) {
            return t.flag;
        }
        char c = str.charAt(0);
        return searchRecursive(t.trieTreeNodes[c - 'a'],str.substring(1));
    }

    public void print(){
        printRecursive(root,"");
    }

    public void printRecursive(TrieTreeNode t,String str){
        if(t == null) return;
        if(t.flag == true) System.out.println(str);
        for(int i =0;i<=25;i++){
            printRecursive(t.trieTreeNodes[i],str +String.valueOf((char)('a' + i)));
        }
        return;
    }

}
