package com.practice.DP;

import java.util.Scanner;

/*
0-1 Knapsack problem
 */
public class Problem11 {
    public static void main(String args[]) {
        int t, T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for (t = 0; t < T; t++) {
            int W,N;
            N = s.nextInt();
            W = s.nextInt();
            int[] w = new int[N];
            int[] v = new int[N];
            for(int i=0;i<N;i++){
                v[i] = s.nextInt();
            }
            for(int i=0;i<N;i++){
                w[i] = s.nextInt();
            }
            System.out.println(maxValue(w,v,W,N));
        }
    }

    public static int maxValue(int[] w,int[] v,int W,int N){
        int[][] dp = new int[W+1][N];
        for(int j=0;j<N;j++){
            dp[0][j] = 0;
        }
        for(int i=0;i<=W;i++){
            if(i<w[0]) dp[i][0] = 0;
            else dp[i][0] = v[0];
        }
        for(int i=0;i<=W;i++){
            for(int j=1;j<N;j++){
                int x = (i-w[j] >=0)?dp[i-w[j]][j-1] + v[j]:0;
                int y = dp[i][j-1];
                dp[i][j] = Math.max(x,y);
            }
        }
        return dp[W][N-1];
    }
}
