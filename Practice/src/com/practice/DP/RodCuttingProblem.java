package com.practice.DP;

import java.util.Arrays;
import java.util.Scanner;

public class RodCuttingProblem {
    public static void main(String args[]) {
        int t, T, N;
        Scanner s = new Scanner(System.in);
        int[] x = new int[3];
        T = s.nextInt();
        for (t = 0; t < T; t++){
            N = s.nextInt();
            for (int i = 0; i < 3; i++) {
                x[i] = s.nextInt();
            }
            Arrays.sort(x);
            System.out.println(maxSegments(N,x));
        }
    }

    private static int maxSegments(int N,int x[]){
        if(N == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<x.length;i++){
            int r = N - x[i];
            int l = 0;
            if(r >= x[0])
                l = 1 + maxSegments(N - x[i],x);
            else
                l = 0;
            if(l >= max) max = l;
        }
        return max;
    }

    private static int maxSegmentsDP(int N,int x[]){
        int[] dp = new int[N + 1];
        for(int i =0;i<=N;i++){
            int l = 0;
            int max = 0;
            for(int j =0;j<x.length;j++){
                 l = (i-x[j] >= 0)? 1 + dp[i-x[j]]:0;
                 if(l > max) max =l;
            }
            dp[i] = max;
        }
        return dp[N];
    }


}
