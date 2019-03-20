package com.practice.greedytechnique;

/*
https://www.hackerrank.com/challenges/candies/problem
*/

import java.util.Arrays;

public class Candies {
    public static void main(String args[]){
        int[] arr = {2, 4, 3 ,5 ,2 ,6 ,4 ,5};
        System.out.println(candies(8,arr));

    }

    static long candies(int n, int[] arr) {
        int[] candies = new int[n];
        //valleys
        for(int i = 0; i < n; i++){
            if((i == 0 && arr[i] <= arr[i + 1]) || (i == n-1 && arr[i-1] >= arr[i]) || (arr[i] <= arr[i-1] && arr[i+1] >= arr[i]))
                candies[i] = 1;
        }
        //rises
        for(int i = 1; i < n; i++){
            if(i != n-1 && arr[i] > arr[i-1] && arr[i] <= arr[i+1])
                candies[i] = candies[i-1] + 1;
            if(i == n-1 && arr[i] > arr[i-1])
                candies[i] = candies[i-1] + 1;
        }
        //falls
        for(int i = n - 2; i >= 0; i--){
            if(i != 0 && arr[i] >= arr[i + 1] && arr[i-1] > arr[i])
                candies[i] = candies[i+1] + 1;
            if(i == 0 && arr[i] >= arr[i + 1])
                candies[i] = candies[i+1] + 1;
        }
        //peaks
        for(int i = 1;i <= n-2;i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1])
                candies[i] = Math.max(candies[i-1],candies[i+1]) + 1;
        }
        return Arrays.stream(candies).sum();
    }
}
