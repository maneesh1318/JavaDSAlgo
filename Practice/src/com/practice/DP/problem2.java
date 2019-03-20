package com.practice.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class problem2 {
    public static void main(String args[]){
        int T,t;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            Long n = s.nextLong();
            System.out.println(numberOfWays(n));
        }


    }

    public static Long numberOfWays(Long N){
        List<Matrix> dp = new ArrayList<>();
        Matrix I = new Matrix(2,2);
        Matrix M = new Matrix(2,2);
        I.set(0,0,1);
        I.set(0,1,0);
        I.set(1,0,0);
        I.set(1,1,1);
        M.set(0,0,1);
        M.set(0,1,1);
        M.set(1,0,1);
        M.set(1,1,0);
        List<Integer> L = getSetBitList(N);
        int highestSetBit = L.get(L.size()-1);
        dp.add(I);
        dp.add(M);
        Matrix Square = multiply(M,M);
        for(int i =2;i<=highestSetBit;i++){
            dp.add(multiply(dp.get(i-1),dp.get(i-1)));
        }
        Matrix S = new Matrix(2,2);
        S.set(0,0,1);
        S.set(0,1,0);
        S.set(1,0,0);
        S.set(1,1,1);
        for(int i=0;i<L.size();i++){
            S = multiply(S,dp.get(L.get(i)));
        }
        return S.get(0,0) + S.get(0,1);
    }

    public static List<Integer> getSetBitList(long N){
        List<Integer> L = new ArrayList<>();
        int i = 0;
        Long one = 1l;
        while (N > 0){
            if((N&one) == 1)
                L.add(i);
            i++;
            N = N>>1;
        }
        return L;
    }

    public static Matrix multiply(Matrix A,Matrix B){
        if(A.getCols() != B.getRows()){
            System.out.println("Multiplication Not Possible");
            return null;
        }
        Matrix R = new Matrix(A.getRows(),B.getCols());
        for(int i=0;i<A.getRows();i++){
            for(int j=0;j<B.getCols();j++){
                long S = 0;
                for(int k = 0;k<A.getCols();k++){
                    S = S + (A.get(i,k)) * (B.get(k,j));
                }
                R.set(i,j,S);

            }
        }
        return R;
    }
}

class Matrix{
    int rows;
    int cols;
    public long [][] M;

    Matrix(int rows,int cols){
        this.rows = rows;
        this.cols = cols;
        M = new long[rows][cols];
    }

    void initialize(long[][] arr){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                M[i][j] = arr[i][j];
            }
        }
    }

    int getRows(){
        return rows;
    }

    int getCols(){
        return cols;
    }

    long get(int i,int j){
        return M[i][j];
    }

    void set(int i,int j,long elm){
        M[i][j] = elm;
    }
}


