package com.practice.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int N = s.nextInt();
            List<Integer> p = new ArrayList<>(N);
            for(int i =0;i<N;i++){
                p.add(s.nextInt());
            }
            //System.out.println(minOperations(p));
            System.out.println(minOperationsDP(p));
        }
    }

    public static int minOperations(List<Integer> p){
        if(p.size() == 2) return 0;
        if(p.size() == 3) return p.stream().reduce(1,(a,b) -> a * b);
        int op = Integer.MAX_VALUE;
        for(int i = 1;i<=p.size() - 2;i++){
            List<Integer> p1 = p.subList(0,i + 1);
            List<Integer> p2 = p.subList(i,p.size());
            int op1 = minOperations(p1);
            int op2 = minOperations(p2);
            op = Math.min(op,op1 + op2 + p1.get(0) * p1.get(p1.size() - 1) * p2.get(p2.size() -1));
        }
        return op;
    }

    public static int minOperationsDP(List<Integer> p){
        int L = p.size() - 1;
        int[][] dp = new int[L + 1][L + 1];
        for(int l = 2;l <= L;l++){
            for(int i = 1; i <= L - l + 1; i++){
                int j = i + l - 1;
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    min = Math.min(min,dp[i][k] + dp[k+1][j] + p.get(i-1) * p.get(k) * p.get(j));
                }
                dp[i][j] = min;
            }
        }
        return dp[1][p.size() - 1];
    }


}
