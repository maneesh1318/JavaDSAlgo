package com.practice.misc;

import java.util.Arrays;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 14/7/18.
 */
public class ZeroSumTriplet {
    public static void main(String args[]){
        int[] A = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
        threeSum(A);

    }


    public static int[][] threeSum(int[] A) {
        int sol[][] = new int[3][3];
        Arrays.sort(A);
        int ind = 0;
        for(int i = 0;i<A.length - 2;i++){
            if(i != 0 && A[i] == A[i-1]) continue;
            int s = - A[i];
            int j = i + 1;
            int k = A.length - 1;
            while(j<k){
                if(j == i){
                    j++;
                    continue;
                }
                if(k == i){
                    k--;
                    continue;
                }
                if(A[i] + A[j] + A[k] == 0) {
                    System.out.println(A[i] + "," + A[j] + "," + A[k]);
                    sol[ind][0] = A[i];
                    sol[ind][1] = A[j];
                    sol[ind][2] = A[k];
                    j++;
                    k--;
                    ind++;
                }
                else if(A[i] + A[j] + A[k] > 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return sol;
    }
}
