package com.practice.misc;

import java.util.Arrays;

public class GroupAnagrams {
    public static void main(String args[]){
        String[] arr = {"cat", "dog","here","tac","god","act"};
        countAnagrams(arr);

    }

    public static void countAnagrams(String[] arr){
        for(int i = 0;i<arr.length;i++){
            char[] t = arr[i].toCharArray();
            Arrays.sort(t);
            arr[i] = new String(t);
        }
        Arrays.sort(arr);
        int ind = 1;
        String curr = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(curr.equals(arr[i])) ind++;
            else{
                System.out.print(ind + " ");
                ind = 1;
                curr = arr[i];
            }
        }

    }


}
