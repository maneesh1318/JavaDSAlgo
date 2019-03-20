package com.practice.DP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestBitonicSubsequence {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int N = s.nextInt();
            int[] arr = new int[N];
            for(int i =0;i<N;i++){
                arr[i] = s.nextInt();
            }
            System.out.println(longestBitonicSubsequence(arr));
        }
    }

    public static int longestBitonicSubsequence(int arr[]){
        int[] lis = new int[arr.length + 1];
        int[] lds = new int[arr.length + 1];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = 0;j<=i;j++){
                if(arr[i] > arr[j]) max = Math.max(lis[j],max);
            }
            lis[i] = max + 1;
        }
        for(int i = arr.length - 2;i >= 0;i--){
            int max = 0;
            for(int j = arr.length - 1;j >= i; j--){
                if(arr[i] > arr[j]) max = Math.max(max,lds[j]);
            }
            lds[i] = max + 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i= 0;i<arr.length;i++){
            max = Math.max(lis[i] + lds[i],max);
        }
        return max -1;
    }
}
