package com.practice.misc;

import java.util.*;

public class Main {
    public static void main(String args[]){
        int N,K,M;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        K = s.nextInt();
        M = s.nextInt();
        List<String> r = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            r.add(s.next());
        }
        printRecords(r,N,K,M);
    }

    public static void printRecords(List<String> r,int N,int K,int M) {
        int numRecords = ((M - 1) * K + 1);
        if(numRecords == 0) return;
        for(int i = numRecords; i <= (M *K); i++){
            System.out.println(r.get(i-1));
        }
    }
}
