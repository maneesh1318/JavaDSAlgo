package com.practice.misc;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacterInStream {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t < T;t++){
            Map<Character,Integer> M = new LinkedHashMap<>(26);
            LinkedList<Character> L = new LinkedList<>();
            int N = s.nextInt();
            for(int i =0;i<N;i++){
                char c = s.next().charAt(0);
                if(M.get(c) == null){
                    M.put(c,1);
                    L.addLast(c);
                }
                else{
                    M.put(c,M.get(c) + 1);
                    if(!L.isEmpty() && L.peekFirst().equals(c)){
                        L.removeFirst();
                    }
                }
                if(L.isEmpty()){
                    System.out.print("-1 ");
                }
                else{
                    while (!L.isEmpty() && M.get(L.peekFirst()) != 1) L.removeFirst();
                    if(L.isEmpty()){
                        System.out.print("-1 ");
                    }
                    else System.out.println(L.peekFirst() + " ");
                }
            }
            System.out.println();
        }
    }
}
