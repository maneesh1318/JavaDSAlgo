package com.practice.misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumPlatforms {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t<T;t++){
            int N = s.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];
            for(int i = 0; i < N ; i++){
                A[i] = s.nextInt();
            }
            for(int i = 0; i < N ; i++){
                B[i] = s.nextInt();
            }
            System.out.println(minPlatforms(A,B,N));
        }
    }

    public static int minPlatforms(int[] A,int[] D,int N){
        class data {
            public int time;
            public char type;

            data(int time, char type) {
                this.time = time;
                this.type = type;
            }
        }
        data[] arr = new data[2 * N];
        for(int i = 0;i<N;i++){
            arr[i] = new data(A[i],'A');
            arr[i + N] = new data(D[i],'B');
        }
        Arrays.sort(arr, new Comparator<data>() {
            @Override
            public int compare(data o1, data o2) {
                return o1.time - o2.time;
            }
        });
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0;i < 2*N - 1;i++){
            if(i > 0 && arr[i - 1] == arr[i]) continue;
            count = (arr[i].type == 'A')? count + 1: count - 1;
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}
