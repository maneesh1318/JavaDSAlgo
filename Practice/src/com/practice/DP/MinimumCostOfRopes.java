package com.practice.DP;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostOfRopes {
    public static void main(String[] args){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t<T;t++){
            int N = s.nextInt();
            int[] L = new int[N];
            for(int i = 0;i < N;i++){
                L[i] = s.nextInt();
            }
            System.out.println(minCostPQ(L,N));
        }
    }

    public static int minCost(int[] L, int N){
        return 0;
    }

    public static int minCostPQ(int[] L,int N){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<N;i++){
            pq.add(L[i]);
        }
        int minCost = 0;
        while (!pq.isEmpty() && pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            minCost += (a+b);
            pq.add(a + b);
        }
        return minCost;
    }


}
