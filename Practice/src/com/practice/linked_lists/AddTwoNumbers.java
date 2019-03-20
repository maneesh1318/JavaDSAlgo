package com.practice.linked_lists;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 15/7/18.
 */
public class AddTwoNumbers {
    public static void main(String agrs[]){
        List L1 = null;
        List L2 = null;
        L1 = insert(L1,9);
        L1 = insert(L1,9);
        L1 = insert(L1,9);
        L1 = insert(L1,9);
        L2 = insert(L2,0);
        L2 = insert(L2,0);
        L2 = insert(L2,0);
        L2 = insert(L2,1);
        List L3 = add(L1,L2,null);
        print(L1);
        System.out.println();
        print(L2);
        System.out.println();
        print(L3);

    }

    static List insert(List L,int elm){
        if(L == null){
            return new List(elm);
        }
        L.next = insert(L.next,elm);
        return L;

    }

    static void print(List L){
        if(L == null) return;
        else{
            System.out.print(L.elm + " ");
            print(L.next);
        }
    }

    static List add(List L1,List L2, Carry carry){
        if(L1 == null && L2 == null){
            carry.carry = 0;
            return null;
        }
        boolean isFirstNode = false;
        if(carry == null) {
            isFirstNode = true;
            carry = new Carry();
        }
        List L3 = add(L1.next,L2.next,carry);
        int sum = L1.elm + L2.elm + carry.carry;
        List L = new List(sum % 10);
        carry.carry = sum/10;
        L.next = L3;
        if(isFirstNode && carry.carry !=0){
            List C = new List(carry.carry);
            C.next = L;
            return C;
        }
        return L;
    }

}

class Carry{
    public int carry;
    Carry(){
        carry = 0;
    }
}

class List{
    int elm;
    List next;

    List(int elm){
        this.elm = elm;
        this.next = null;
    }


}
