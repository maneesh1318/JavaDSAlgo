package com.practice.DP;

import java.util.Scanner;

public class PathInMatrix {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t<T;t++){
            int N = s.nextInt();
            int[][] a = new int[N][N];
            for(int i =0;i<N;i++){
                for(int j =0;j<N;j++){
                    a[i][j] = s.nextInt();
                }
            }
            System.out.println(maxSumPathDP(a,N));
        }
    }

    public static int maxSumPath(int[][] a,int N){
        int i = 0;
        int max = Integer.MIN_VALUE;
        for(int j =0;j<N;j++){
            max = Math.max(max,maxSumPathUtil(a,N,i,j));
        }
        return max;
    }

    public static int maxSumPathUtil(int[][] a,int N,int r,int c){
        if(r >= N || r < 0) return 0;
        if(c < 0 || c >= N) return 0;
        int s1 = maxSumPathUtil(a,N,r+1,c-1);
        int s2 = maxSumPathUtil(a,N,r+1,c);
        int s3 = maxSumPathUtil(a,N,r+1,c+1);
        return a[r][c] + Math.max(s1,Math.max(s2,s3));
    }

    public static int maxSumPathDP(int[][] a,int N){
        int[][] dp = new int[N][N];
        int max = 0;
        for(int i = 0;i< N;i++){
            for(int j =0 ;j < N;j++){
                if(i == 0){
                    dp[i][j] = a[i][j];
                    continue;
                }
                int s1 = (j == 0)?0:dp[i-1][j-1];
                int s2 = dp[i-1][j];
                int s3 = (j== N-1)?0:dp[i-1][j+1];
                dp[i][j] = a[i][j] + Math.max(s1,Math.max(s2,s3));
                if(i == N - 1){
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
