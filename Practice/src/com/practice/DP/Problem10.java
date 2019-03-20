package com.practice.DP;

import java.util.Scanner;

public class Problem10 {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int N;
            N = s.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = s.nextInt();
            }
            if(canBePartitioned(arr,N)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    public static boolean canBePartitioned(int[] arr,int N){
        int s = 0;
        for(int i=0;i<N;i++){
            s += arr[i];
        }
        if(s % 2 != 0) return false;
        s = s/2;
        int[][] dp = new int[s+1][N];
        for(int j=0;j<N;j++){
            dp[0][j] = 1;
        }
        for(int i=0;i<=s;i++){
            dp[i][0] = (i == arr[0])?1:0;
        }
        int x,y;
        for(int i=1;i<=s;i++){
            for(int j=1;j<N;j++){
                x = (i-arr[j] >=0)?dp[i-arr[j]][j-1]:0;
                y = dp[i][j-1];
                dp[i][j] = x|y;
            }
        }
        return dp[s][N-1] == 1;
    }
}
