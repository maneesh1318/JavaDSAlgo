package com.practice.DP;

public class EggDropingPuzzle1 {
    public static void main(String args[]){
        int N = 2;
        int K =  10;
        System.out.println(minAttemptsDP(10,2));
    }

    public static int minAttempts(int K, int N){
        if(K <= 1)
            return K;
        if(N == 1)
            return K;
        int min = Integer.MAX_VALUE;
        for(int i =1; i<=K; i++){
            int t = Math.max(minAttempts(i - 1,N-1),minAttempts(K - i,N));
            if(t < min)
                min = t;
        }
        return min + 1;
    }

    public static int minAttemptsDP(int K,int N){
        int[][] dp = new int[K+1][N+1];
        for(int i =0;i<=K;i++){
            dp[i][1] = i;
        }
        for(int j = 1;j<=N;j++){
            dp[0][j] = 0;
            dp[1][j] =  1;
        }
        for(int i = 1;i<=K;i++){
            for(int j =2;j<=N;j++){
                int min = Integer.MAX_VALUE,res = 0;
                for(int k = 1;k<=i;k++){
                    res = Math.max(dp[k -1][j -1], dp[i-k][j]);
                    if(res < min) min = res;
                }
                dp[i][j] = 1 + min;
            }
        }
        return dp[K][N];
    }
}
