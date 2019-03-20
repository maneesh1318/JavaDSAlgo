package com.practice.misc;

import java.util.Arrays;
import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0 ;t< T;t++){
            int N = s.nextInt();
            int[] a = new int[N];
            for(int i =0;i<N;i++){
                a[i] = s.nextInt();
            }
            System.out.println(tripletExists(a,N));
        }

    }

    public static String tripletExists(int[] a,int N){
        for(int i = 0;i<N;i++){
            a[i] = a[i] * a[i];
        }
        Arrays.sort(a);
        if(a.length < 3) return "No";
        for(int i = N - 1;i >= 2;i--){
            int z = i;
            int x = 0;
            int y = i - 1;
            while (x < y){
                if(a[z] == a[x] + a[y])
                    return "Yes";
                else if(a[z] < a[x] + a[y]){
                    y--;
                }
                else
                    x++;
            }
        }
        return "No";
    }
}
