package com.practice.misc;

public class MaxDifference {
    public static void main(String args[]){
        int[] arr = {99,100,5,10,10,11,20,4,12,18,19,23,0};
        System.out.println(findMaxDiff(arr));
    }

    public static int findMaxDiff(int[] arr){
        int min = arr[0];
        int maxDiff = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            maxDiff = (maxDiff > (arr[i] - min))?maxDiff:(arr[i] - min);
            min = (arr[i] < min)?arr[i]:min;
        }
        return maxDiff;
    }
}
