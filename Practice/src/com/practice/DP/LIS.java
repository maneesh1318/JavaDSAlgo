package com.practice.DP;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {

    public static void main(String args []){
        //int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        //System.out.println(LIS(arr));
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int N = s.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = s.nextInt();
            }
            System.out.println(LIS(arr));
        }
    }

    public static int LIS(int arr[]){
        int[] dp = new int[arr.length];
        int[] print = new int[arr.length];
        Arrays.fill(print,-1);
        dp[0] = 1;
        for(int i=1;i<arr.length;i++){
            int max = 0;
            int maxIndex = -1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                    maxIndex = j;
                }
            }
            dp[i] = max + 1;
            print[i] = maxIndex;
        }
        print(arr,print,arr.length-1);
        System.out.println();
        return dp[arr.length - 1];

    }

    public static void print(int[] arr,int[] print,int index) {
        if (index == -1)
            return;
        print(arr, print, print[index]);
        System.out.print(arr[index] + " ");
    }
}


