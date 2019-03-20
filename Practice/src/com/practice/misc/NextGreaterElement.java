package com.practice.misc;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0; t<T;t++){
            int N = s.nextInt();
            long[] a = new long[N];
            for(int i=0;i<N;i++){
                a[i] = s.nextInt();
            }
            nextGreaterElement(a,N);
        }
    }

    private static void nextGreaterElement(long[] a,int N){
        int l = a.length;
        List<Pair<Integer,Long>> list = new ArrayList<>(l);
        Stack<Pair<Integer,Long>> s = new Stack<>();
        for(int i =0;i<l;i++){
            list.add(new Pair<>(i,a[i]));
        }
        long[] next = new long[l];
        s.push(list.get(0));
        for(int i = 1;i<l;i++){
            Pair<Integer,Long> p = list.get(i);
            int index = p.getKey();
            long value = p.getValue();
            while (!s.isEmpty() && s.peek().getValue() < value){
                Pair<Integer,Long> q = s.pop();
                next[q.getKey()] = value;
            }
            s.push(p);
        }
        while (!s.isEmpty()){
            Pair<Integer,Long> p = s.pop();
            next[p.getKey()] = -1;
        }
        for(int i =0;i<l;i++){
            System.out.print(next[i] + " ");
        }
        System.out.println();
    }
}
