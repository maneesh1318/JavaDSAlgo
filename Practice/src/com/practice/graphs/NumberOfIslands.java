package com.practice.graphs;

import java.util.Scanner;

public class NumberOfIslands {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t < T;t++){
            int N,M;
            N = s.nextInt();
            M = s.nextInt();
            int A[][] = new int[N][M];
            for(int i = 0;i < N;i++){
                for(int j = 0;j < M;j++){
                    A[i][j] = s.nextInt();
                }
            }
            System.out.println(findisland(A,N,M));

        }

    }

    public static int findisland(int[][]a,int n,int m)
    {
        int[][] b = new int[n][m];
        int cnt = 0;
        for(int i = 0 ;i < n;i++){
            for(int j = 0;j < m;j++){
                if(a[i][j] == 1 && b[i][j] == 0) {
                    cnt++;
                    mark(i, j, n, m, a, b);
                }
            }
        }
        return cnt;
    }

    private static void mark(int i,int j,int n,int m,int[][] a, int[][] b){
        if(i < 0 || i >= n) return;
        if(j < 0 || j >= m) return;
        if(a[i][j] == 0) return;
        if(a[i][j] == 1 && b[i][j] == 0) {
            b[i][j] = 1;
            mark(i + 1, j, n, m, a,b);
            mark(i - 1, j, n, m,a, b);
            mark(i, j + 1, n, m, a,b);
            mark(i, j - 1, n, m, a,b);
            mark(i - 1, j - 1, n, m, a,b);
            mark(i - 1, j + 1, n, m, a,b);
            mark(i + 1, j - 1, n, m, a,b);
            mark(i + 1, j + 1, n, m, a,b);
        }
        return;
    }
}
