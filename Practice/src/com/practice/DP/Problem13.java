package com.practice.DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem13 {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int N = s.nextInt();
            int[] height = new int[N];
            int[] length = new int[N];
            int[] width = new int[N];
            for(int i=0;i<N;i++){
                height[i] = s.nextInt();
                width[i] = s.nextInt();
                length[i] = s.nextInt();
            }
            System.out.println(maxHeight(height,width,length,N));
        }
    }

    public static int maxHeight(int height[],int width[],int length[],int N){
        class Cuboid implements Comparable<Cuboid> {
            int area;
            int height;

            Cuboid(int a,int b,int c){
                area = a*b;
                height =c;
            }

            @Override
            public int compareTo(Cuboid C) {
                return this.area - C.area;
            }
        }

        Cuboid[] cuboids = new Cuboid[3 * N];

        int ind = 0;
        for(int i=0;i<N;i++){
            cuboids[ind] = new Cuboid(height[i],width[i],length[i]);
            cuboids[ind + 1] = new Cuboid(height[i],length[i],width[i]);
            cuboids[ind + 2] = new Cuboid(width[i],height[i],length[i]);
        }
        Arrays.sort(cuboids);
        int[] dp = new int[3*N];



        return 0;
    }

    public static int maxHeightDP(int height[],int width[],int length[],int N){
        return 0;
    }
}


