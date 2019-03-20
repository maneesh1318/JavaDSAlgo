package com.practice.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 14/7/18.
 */
public class GasStation {
    public static void main(String args[]){
       int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
       ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        int ind = 0;
       for(int i=0;i<4;i++){
           a.add(new ArrayList<Integer>());
           for(int j=0;j<4;j++){
               a.get(i).add(arr[ind++]);
           }
       }
        Solution solution = new Solution();
        solution.rotate(a);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(a.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}

class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int minS = Integer.MAX_VALUE;
        int S = 0;
        int position = 0;
        for(int i =0;i<A.length;i++){
            S = S + (A[i] - B[i]);
            if(S < minS){
                minS = S;
                position = (i + 1) % A.length;
            }
        }
        if(S >= 0) return position;
        else return -1;
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        Collections.reverse(a);
        for(int i=0;i < a.size();i++){
            for(int j =0;j< i;j++){
                if(i != j){
                    int temp1 = a.get(i).get(j);
                    int temp2 = a.get(j).get(i);
                    a.get(i).set(j,temp2);
                    a.get(j).set(i,temp1);
                }
            }
        }
        return;
    }
}
