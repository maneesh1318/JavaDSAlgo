package com.practice.misc;

import java.util.Scanner;

public class MaximizeMatrixSum {
    public static void main(String args []) {
        int M, N;
        Scanner s = new Scanner(System.in);
        M = s.nextInt();
        N = s.nextInt();
        long [][] A  = new long[M][N];
        for(int i =0;i<M;i++){
            for(int j =0;j<N;j++){
                A[i][j] = s.nextLong();
            }
        }
        System.out.println(maxSum(A,M,N));
    }

    public static long maxSum(long[][] A, int M,int N){
        long[] rows = new long[M];
        long[] cols = new long[N];
        long S = 0;
        for(int i=0;i<M;i++){
            for(int j =0;j<N;j++){
                S += A[i][j];
                rows[i] += A[i][j];
                cols[j] += A[i][j];
            }
        }
        long minRow = Long.MAX_VALUE;
        long minCol = Long.MAX_VALUE;
        for(int i =0;i<M;i++){
            if(rows[i] < minRow) minRow = rows[i];
        }
        for (int j =0;j<N;j++){
            if(cols[j] < minCol) minCol = cols[j];
        }
        return S - Math.min(minCol,minRow);

    }

}
