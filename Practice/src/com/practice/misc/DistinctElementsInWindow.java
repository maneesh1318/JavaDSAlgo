package com.practice.misc;

import java.util.*;

public class DistinctElementsInWindow {
    public static void main(String args[]){
        Integer[] arr = {78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27};
        int k = 5;
        count(arr,k);

    }

    public static void count(Integer[] arr,Integer k){
        int l = arr.length;
        Map<Integer,Integer> M = new LinkedHashMap<>(arr.length);
        for(int i =0;i<k;i++){
            add(M,arr[i]);
        }
        System.out.println(M.size());
        for(int i =k;i< arr.length;i++){
            remove(M,arr[i-k]);
            add(M,arr[i]);
            System.out.println(M.size());
        }
    }

    public static void remove(Map<Integer,Integer> M,int num){
        if(M.get(num) != null)
            M.put(num,M.get(num) - 1);
        if(M.get(num) == 0) M.remove(num);
    }

    public static void add(Map<Integer,Integer> M,int num){
        if(M.get(num) != null)
            M.put(num,M.get(num) + 1);
        else
            M.put(num,1);
    }
}
