package com.practice.misc;

import java.util.Scanner;

public class RainWaterTapping {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int N  = s.nextInt();
            int[] a = new int[N];
            for(int i =0;i<N;i++){
                a[i] = s.nextInt();
            }
            System.out.println(water(a,N));
        }
    }

    public static int water(int[] a,int N){
        int[] lmax = new int[N];
        int[] rmax = new int[N];
        int water = 0;
        int j = N-1;
        lmax[0] = a[0];
        rmax[N-1] = a[N-1];
        for(int i =1;i<N;i++){
            j = N - 1 - i;
            lmax[i] = Math.max(lmax[i-1],a[i]);
            rmax[j] = Math.max(a[j],rmax[j+1]);
        }
        for(int i =0;i<N;i++){
            water += (Math.min(lmax[i],rmax[i])-a[i]);
        }
        return water;
    }

}
