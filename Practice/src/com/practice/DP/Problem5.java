package com.practice.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
    public static void main(String args[]){
        int N;
        List<Integer> prime = getPrimeUpto5000();
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        List<Integer> L = new ArrayList<>(N);
        for(int i=0;i<N;i++){
            int x = s.nextInt();
            L.add(x);
        }
        long max  = 0;
        int dp[][] = new int[5000][5000];
        for(int i =0;i<N;i++){
            for(int j = i;j<N;j++){
                if(i == j){
                    dp[j][j] = L.get(i);
                }
                else{
                    dp[i][j] = dp[i][j-1] + L.get(j);
                }
                int p = j - i + 1;
                if(prime.contains(p) && max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);
    }

    private static List<Integer> getPrimeUpto5000(){
        List<Integer> L = new ArrayList<>();
        for(int i=1;i<=5000;i++){
            if(isPrime(i)) L.add(i);
        }
        return L;
    }

    private static boolean isPrime(int N){
        if(N == 1| N == 2 | N ==3) return true;
        for(int i = 2;i<= Math.pow(N,0.5);i++){
            if(N % i == 0) return false;
        }
        return true;
    }
}
