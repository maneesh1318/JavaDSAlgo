package com.practice.spoj;

import java.util.Scanner;

public class Martian {
    final static int ZERO = 0;
    final static int NORTH = -1;
    final static int WEST = -2;

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        while(true){
            int m = s.nextInt();
            int n = s.nextInt();
            if(m == 0 && n == 0) break;
            int[][] Y = new int[n][m];
            int[][] B = new int[n][m];
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    Y[i][j] = s.nextInt();
                }
            }
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    B[i][j] = s.nextInt();
                }
            }
            maxAmount(Y,B,n,m);
        }

    }

    public static int maxAmount(int[][] Y,int[][] B,int n,int m) {
        int[][] rowsY = new int[n][m];
        int[][] colsY = new int[n][m];
        int[][] rowsB = new int[n][m];
        int[][] colsB = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    rowsY[i][j] = Y[i][j];
                    rowsB[i][j] = B[i][j];
                } else {
                    rowsY[i][j] = rowsY[i][j - 1] + Y[i][j];
                    rowsB[i][j] = rowsB[i][j - 1] + B[i][j];
                }
                if(i == 0){
                    colsY[i][j] = Y[i][j];
                    colsB[i][j] = B[i][j];
                }
                else{
                    colsY[i][j] = colsY[i-1][j] + Y[i][j];
                    colsB[i][j] = colsB[i-1][j] + B[i][j];
                }
            }
        }
        printMatrix(Y);
        System.out.println();
        printMatrix(B);
        System.out.println();
        printMatrix(rowsY);
        System.out.println();
        printMatrix(rowsB);
        System.out.println();
        printMatrix(colsY);
        System.out.println();
        printMatrix(colsB);
        System.out.println();
        return 0;
    }

    //int maxAmountRecur(int[][] Y, int B[][],int m,int n,int[][] rowY)

    public static void printMatrix(int[][] M){
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[i].length; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }
}
