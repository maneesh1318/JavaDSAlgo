package com.practice.misc;

import java.util.Scanner;

class MIN{
    public static int minJumps = Integer.MAX_VALUE;
}

public class GrofersOnlineTest2 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n ;i++){
            arr[i] = s.nextInt();
        }
        //minJumps(arr,n,0,0);
        //System.out.println(MIN.minJumps);
        System.out.println(minJumpsDP(arr,n));

    }

    public static void minJumps(int arr[],int n,int index,int jumps){
        if(index >= n || arr[index] == 0 ) return;
        if(index == n - 1){
            MIN.minJumps = Math.min(MIN.minJumps,jumps);
            return;
        }
        for(int i = 1;i <= arr[index];i++) {
            minJumps(arr, n, index + i, jumps + 1);
        }
    }

    public static int minJumpsDP(int[] arr,int n){
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i < n;i++){
            int minJump = Integer.MAX_VALUE;
            for(int j = 0;j < i;j++){
                if(j + arr[j] >= i){
                    minJump = Math.min(minJump,dp[j]);
                }
            }
            dp[i] = minJump + 1;
        }
        return dp[n-1];
    }


}
