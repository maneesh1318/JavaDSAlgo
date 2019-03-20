package com.practice.DP;

public class EggDropingPuzzle {
    public static void main(String args[]){
        int N = 2;
        int K =  10;
        System.out.println(minAttempts(K,N));
    }

    public static int minAttempts(int K, int N){
        if(K ==0 || K == 1)
            return K;
        if(N == 1)
            return K;
        int min = Integer.MAX_VALUE;
        for(int i =1; i<=K; i++){
            int t = Math.max(minAttempts(i - 1,N-1),minAttempts(K - i,N));
            if(t < min);
                min = t;
        }
        return min + 1;
    }
}
