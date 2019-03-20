package com.practice.misc;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 22/7/18.
 */
public class BinarySearchInRotatedArray {
    public static void main(String[] args){
        //int[] arr = {5,6,7,8,9,10,1,2,3};
        //int[] arr = {5,6,7,8,9,10,1,2,3};
        int[] arr = {1,2,3,0};
        System.out.println(findPivot(arr,0,arr.length-1));

    }

    public static int findPivot(int arr[],int low,int high){
        if(low >= high) return -1;
        int mid = (low + high)/2;
        if(mid > low && arr[mid] < arr[mid-1] || (mid < high && arr[mid] < arr[mid+1])) return mid;
        int p1 = findPivot(arr,low,mid);
        int p2 = findPivot(arr,mid+1,high);
        return (p1 != -1)?p1:p2;
    }
}
