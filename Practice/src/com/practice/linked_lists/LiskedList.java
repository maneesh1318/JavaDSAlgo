package com.practice.linked_lists;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 12/6/18.
 */
public class LiskedList {
    public static void main(String args[]){

    }
}

class ListNode<T extends Number>{
    T elm;
    ListNode<T> next;

    ListNode(T elm){
        this.elm = elm;
        this.next = null;
    }
}

class LinkedList<T extends Number>{
    int length;
    ListNode<T> L;

    LinkedList(){
        L = null;
        length = 0;
    }

    public void insert(T elm){
        L = insertRecursive(L,elm);
        length++;
    }

    public void print(){
        ListNode<T> P = L;
        while(P != null){
            System.out.print(P.elm + " ");
            P = P.next;
        }
        System.out.println();
    }

    public ListNode<Integer> modify(ListNode<Integer> l,int n){
        if(length % 2 == 0 && n == length/2){
            l.next.elm = l.next.elm + l.elm;
            return l.next.next;

        }
        else if(length % 2 != 0 && (n == length/2 + 1)){
            l.elm =  2 * l.elm;
            return l.next;
        }
        else {
            ListNode<Integer> t = modify(l.next,n+1);
            t.elm = t.elm + l.elm;
            return t.next;
        }
    }

    private ListNode<T> insertRecursive(ListNode P, T elm){
        if(P == null) return new ListNode<T>(elm);
        P.next =  insertRecursive(P.next,elm);
        return P;
    }

}
