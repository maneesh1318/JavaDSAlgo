package com.practice.DP;

import java.util.Scanner;

public class Problem12 {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int N = s.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = s.nextInt();
            System.out.println(minJumpsDP(arr,N));
        }

    }

    public static int minJumps(int[] arr,int N,int index){
        if(index >= N -1)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=arr[index];i++){
            int m = minJumps(arr,N,index + i);
            if(m < min) min = m;
        }
        return min + 1;

    }

    public static int minJumpsDP(int arr[],int N){
        int[] dp = new int[N];
        dp[N-1] = 0;
        for(int i = N-2;i>=0;i--){
            int maxStep = arr[i];
            int min = Integer.MAX_VALUE - 101;
            for(int j=1;j<=maxStep && i+j <= N-1;j++){
                if((dp[i+j] + 1) < min) min = dp[i+j] + 1;
            }
            dp[i] = min;
        }
        if(dp[0] == Integer.MAX_VALUE) return -1;
        return dp[0];
    }
}
