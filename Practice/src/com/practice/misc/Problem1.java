package com.practice.misc;

import java.util.Scanner;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 21/7/18.
 * Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
 */
public class Problem1 {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        int arr[] = {3,2,6,4,5,2,8,9};
        T = s.nextInt();
        for(t=0;t<T;t++){
            int n = s.nextInt();
            int[] A = new int[n];
            for(int i =0;i<n;i++) A[i] = s.nextInt();
            System.out.println(find(A));
        }

    }

    public static int find(int [] arr){
        if(arr.length == 0) return -1;
        int[] A = new int[arr.length];
        int[] B = new int[arr.length];
        int currMax = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;
        int j = arr.length - 1;
        for(int i =0 ;i < arr.length; i++){
            if(arr[i] >= currMax){
                currMax = arr[i];
            }
            if(arr[j-i] < currMin){
                currMin = arr[j-i];
            }
            A[i] = currMax;
            B[j-i] = currMin;
        }
        for(int i =0;i < A.length;i++){
            if(A[i] == B[i]){
                if(i == 0){
                    if(B[i] != B[i+1])
                        return arr[i];
                    else
                        return -1;
                }
                else if(i == A.length -1){
                    if(A[i] != A[i -1])
                        return arr[i];
                    else
                        return -1;
                }
                else{
                    if((A[i] != A[i-1]) && (B[i] != B[i+1])){
                        return arr[i];
                    }
                    else return -1;
                }
            }
        }
        return -1;
    }
}
