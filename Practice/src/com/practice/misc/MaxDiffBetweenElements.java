package com.practice.misc;

import java.util.Scanner;

public class MaxDiffBetweenElements {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int N = s.nextInt();
            int[] a = new int[N];
            for(int i = 0;i< N;i++){
                a[i] = s.nextInt();
            }
            System.out.println(findMaxDiff(a,N));
        }

    }

    public static int findMaxDiff(int[] a,int N){
        int min = a[0];
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 1;i<N;i++){
            maxDiff = Math.max(maxDiff,a[i] - min);
            min = Math.min(min,a[i]);
        }
        return maxDiff;
    }

}
