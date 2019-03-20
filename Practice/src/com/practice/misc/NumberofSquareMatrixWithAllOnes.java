package com.practice.misc;

import java.util.Scanner;

public class NumberofSquareMatrixWithAllOnes {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] M = new int[N][N];
        for(int i = 0; i < N;i++){
            for(int j = 0 ; j < N; j++){
                M[i][j] = s.nextInt();
            }
        }
        System.out.println(NumberOfSquareMatrix(M,N));
    }

    public static int NumberOfSquareMatrix(int[][] M, int N){
        int[][] S = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j< N; j++){
                if(i == 0 || j == 0) S[i][j] = M[i][j];
                else{
                    S[i][j] = (M[i][j] == 1) ? Math.min(S[i-1][j-1],Math.min(S[i-1][j],S[i][j-1])) + 1:0;
                }
            }
        }
        int num = 0;
        for(int l = 2;l <= N; l++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(S[i][j] >= l) num++;
                }
            }
        }
        return num;
    }
}
