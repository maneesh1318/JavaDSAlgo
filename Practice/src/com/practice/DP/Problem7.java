package com.practice.DP;

import java.util.Scanner;

public class Problem7 {
    public static void main(String args[]){
        int N;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int[] a = new int[500];
        for(int i =0;i<N;i++){
            a[i] = s.nextInt();
        }
        int [][]dp = new int[500][500];
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                if(i == j){
                    dp[i][j] = 1;
                }
                else{

                }
            }
        }
    }
}
