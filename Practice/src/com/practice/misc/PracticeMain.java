package com.practice.misc;

import java.util.Scanner;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 28/5/18.
 */
public class PracticeMain {
    private final static int INFINITY = 1000000;
    private final static int NINFINITY = -1;
    public static void main(String args[]){
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        scanner.nextLine();
        for(int t = 0;t<T;t++){
            int res = INFINITY;
            int N = scanner.nextInt();
            int arr[] = new int[100000];
            scanner.nextLine();
            for(int n = 0;n<N;n++){
                arr[n] = scanner.nextInt();
            }
            int min = INFINITY,max = NINFINITY;
            for(int i =0;i<N-1;i++){
                for(int j= i+1;j<N;j++){
                    for(int k = i;k<=j;k++) {
                        if (arr[k] < min) min = arr[k];
                        if (arr[k] > max) max = arr[k];
                    }
                    if(res > min + max) res = min + max;
                }
            }
            System.out.println(res);
        }
    }
}
