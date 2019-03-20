package com.practice.DP;
/*
Coin change problem
 */

import java.util.Scanner;

public class Problem9 {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int N,M;
            M = s.nextInt();
            int[] S = new int[M];
            for(int i=0;i<M;i++){
                S[i] = s.nextInt();
            }
            N = s.nextInt();
            System.out.println(numberOfWays(S,M,N));
        }
    }

    public static int numberOfWays(int[] S,int M,int N){
        int x,y;
        int[][] dp = new int[M][N+1];
        for(int i=0;i<M;i++){
            dp[i][0] = 1;
        }
        for(int i = 0;i<M;i++){
            for(int j=1;j<=N;j++){
                x = (j - S[i] >= 0)?dp[i][j-S[i]]:0;
                y = (i>=1)?dp[i-1][j]:0;
                dp[i][j] = x+y;
            }
        }
        return dp[M-1][N];
    }
}
