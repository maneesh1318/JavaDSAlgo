package com.practice.linked_lists;

import javafx.util.Pair;

class LinkedListNode<T>{
    T elm;
    LinkedListNode<T> next;
    LinkedListNode(T elm){
        this.elm = elm;
    }
}



public class LinkedListNew {
    private static class data{
        public boolean isPalindrome;
        public LinkedListNode<Character> l;
        data(boolean isPalindrome,LinkedListNode<Character> l){
            this.isPalindrome = isPalindrome;
            this.l = l;
        }
    }

    public static void main(String args[]){
        String str = "BACDXCAB";
        //String str = "NAME";
        LinkedListNode<Character> L = null;
        for(int i=0;i<str.length();i++){
            L = insert(L,str.charAt(i));
        }
        print(L);
        if(isPalindrome(L)){
            System.out.println("Linked List is palindrome");
        }
        else{
            System.out.println("Linked list is not palindrome");
        }
        //Pair<LinkedListNode<Character>,LinkedListNode<Character>> P = reverse(L);
        //print(P.getKey());


    }

    public static boolean isPalindrome(LinkedListNode<Character> L){
        int length = length(L);
        data d = isPalindromeUtil(L,1,length);
        return d.isPalindrome;
    }

    private static data isPalindromeUtil(LinkedListNode<Character> L,int ind,int length){
        if(L == null)
            return new data(true,null);
        if(length % 2 == 0 && ind == length/2){
            return (L.elm == L.next.elm)?new data(true,L.next.next):new data(false,L.next.next);
        }
        if(length % 2 != 0 && ind == length/2 + 1){
            return new data(true,L.next);
        }
        data d = isPalindromeUtil(L.next,ind + 1,length);
        if(d.isPalindrome && d.l.elm == L.elm) return new data(true,d.l.next);
        return new data(false,null);
    }

    public static <T> int length(LinkedListNode<T> L){
        if(L == null) return 0;
        return 1 + length(L.next);
    }

    public static LinkedListNode<Character> insert(LinkedListNode<Character> L,Character C){
        if(L == null)
            return new LinkedListNode<>(C);
        else
            L.next = insert(L.next,C);
        return L;
    }

    public static void print(LinkedListNode<Character> L){
        if(L == null){
            System.out.println();
            return;
        }
        System.out.print(L.elm + " ");
        print(L.next);
    }

    public static Pair<LinkedListNode<Character>,LinkedListNode<Character>> reverse(LinkedListNode<Character> head){
        if(head == null) return new Pair(null,null);
        LinkedListNode<Character> t = head;
        Pair<LinkedListNode<Character>,LinkedListNode<Character>> P;
        while(t.next != null && t.next.elm != ' ') t = t.next;
        if(t.next == null){
            return new Pair<>(head,t);
        }
        else{
            P = reverse(t.next.next);
            P.getValue().next = t.next;
            t.next.next = head;
            t.next = null;
            return new Pair<>(P.getKey(),t);
        }
    }

    /*
    public static  LinkedListNode<Character>[] reverse(LinkedListNode<Character>[] arr){
        List<LinkedListNode<Character>> listNodeList = new ArrayList<>(Arrays.asList(arr));
        listNodeList.removeIf(Objects::isNull);
        Collections.reverse(listNodeList);
        return listNodeList.toArray(new LinkedListNode[listNodeList.size()]);
    }

    public static LinkedListNode<Character>[] split(LinkedListNode<Character> L, Character C){
        if(L == null) return null;
        LinkedListNode<Character>[] listArray = new LinkedListNode[100];
        int i = 0;
        LinkedListNode<Character> head = L;
        LinkedListNode<Character> prev = null;
        listArray[i++] = head;
        while(head != null){
            if(head.elm == C){
                prev.next = null;
                listArray[i++] = head.next;
            }
            prev = head;
            head = head.next;
        }
        prev.next =null;
        return listArray;
    }

    public static LinkedListNode<Character> join(LinkedListNode<Character>[] listArray, Character C){
        if(listArray[0] == null) return null;
        int i =0;
        LinkedListNode<Character> head = listArray[0];
        LinkedListNode<Character> prev = null;
        while(i < listArray.length && listArray[i] != null){
            while (head != null){
                prev = head;
                head = head.next;
            }
            prev.next = new LinkedListNode<>(C);
            i++;
            if(i < listArray.length) {
                prev.next.next = listArray[i];
                head  = listArray[i];
                prev = null;
            }
            else{
                prev.next.next = null;
            }
        }
        return listArray[0];
    }*/
}



