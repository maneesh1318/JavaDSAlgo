package com.practice.misc;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 16/7/18.
 */
public class Test {
    public static void main(String[] args){
        int n,arr[],temp=-1,flag=0;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        arr = new int[10];
        for(int i=0;i<n;i++)
            arr[i]=in.nextInt();

        Arrays.sort(arr);

        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
        for(int i=1;i<n;i++){
            if(arr[i] == arr[i-1]) {
                temp = arr[i];
                flag=1;
            }
            else if(arr[i] <arr[i-1])
                arr[i] = arr[i-1]+1;
            while(arr[i] == temp) {
                arr[i] = arr[i-1]+1;
                i++;
            }
            if(flag==1){
                i--;flag=0;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }




}
