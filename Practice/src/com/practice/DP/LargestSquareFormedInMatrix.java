package com.practice.DP;

import java.util.Scanner;

public class LargestSquareFormedInMatrix {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int n,m;
            n = s.nextInt();
            m = s.nextInt();
            int[][] C = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j =0;j<m;j++){
                    C[i][j] = s.nextInt();
                }
            }
            System.out.println(largestSquare(C,n,m));
        }
    }

    public static int largestSquare(int[][] M,int n,int m){
        int[][] S = new int[n][m];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i == 0 || j == 0) S[i][j] = M[i][j];
                else{
                    S[i][j] = (M[i][j] == 1) ? Math.min(S[i-1][j-1],Math.min(S[i-1][j],S[i][j-1])) + 1:0;
                }
                if(S[i][j] > max) max = S[i][j];
            }
        }
        return max;
    }


}
