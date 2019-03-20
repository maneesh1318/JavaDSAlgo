package com.practice.misc;

import java.util.Scanner;

public class LargestRectangleUnderHistogram {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t < T;t++){
            int N = s.nextInt();
            int[] A = new int[N];
            for(int i =0;i<N;i++)
                A[i] = s.nextInt();
            System.out.println(largestArea(A));
        }

    }

    public static int largestArea(int[] A){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            int width = 1,j1 = i -1,j2 = i + 1;
            while(j1>=0 && A[j1] >= A[i]){
                width++;
                j1--;
            }
            while(j2 < A.length && A[j2] >= A[i]){
                width++;
                j2++;
            }
            int area = width * A[i];
            if(max < area) max = area;
        }
        return max;
    }
}
