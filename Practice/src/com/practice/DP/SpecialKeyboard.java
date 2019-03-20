package com.practice.DP;

import java.util.Scanner;

public class SpecialKeyboard {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int N = s.nextInt();
            if(N > 75) System.out.println("-1");
            else System.out.println(maxWaysDP(N));
        }
    }

    public static int maxWays(int N){
        if(N <= 6) return N;
        int max  = Integer.MIN_VALUE;
        for(int i =3;i<N;i++){
            int no = maxWays(N - i) * (i-1);
            if(no > max) max = no;
        }
        return max;
    }

    public static int maxWaysDP(int N){
        int[] dp = new int[N + 1];
        for(int i=1;i<=N;i++){
            if(i<=6){
                dp[i] = i;
            }
            else{
                int max = Integer.MIN_VALUE;
                for(int j = 3;j<i;j++){
                    int no = dp[i -j] * (j - 1);
                    if(no > max)  max = no;
                }
                dp[i] = max;
            }
        }
        return dp[N];
    }
}
