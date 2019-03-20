package com.practice.DP;

import java.util.Arrays;
import java.util.Scanner;

public class CountNumberOfWays {
    public static void main(String args[]){
        int t, T, N;
        Scanner s = new Scanner(System.in);
        int[] x = new int[3];
        T = s.nextInt();
        for (t = 0; t < T; t++){
            N = s.nextInt();
            System.out.println(countNumberOfWaysDP(N));
        }

    }

    public static int countNumberOfWays(int N){
        if(N == 0) return 0;
        if(N == 1) return 1;
        if(N == 2) return  2;
        if(N == 3) return 4;
        return countNumberOfWays(N-1) + countNumberOfWays(N -2) + countNumberOfWays(N -3);
    }

    public static int countNumberOfWaysDP(int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4;i<=N;i++){
            dp[i] = dp[i-1] + dp [i-2] + dp [i-3];
        }
        return dp[N];
    }
}
