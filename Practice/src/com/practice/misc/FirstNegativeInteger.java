package com.practice.misc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 Created by Manish Richhariya(manish.richhariya@99acres.com) on 3/7/18.
 Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k. If a window does not contain a negative interger, then print 0 for that window.
 Input : arr[] = {-8, 2, 3, -6, 10}, k = 2
 Output : -8 0 -6 -6
 First negative integer for each window of size k
 {-8, 2} = -8
 {2, 3} = 0 (does not contain a negative integer)
 {3, -6} = -6
 {-6, 10} = -6
 Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 Output : -1 -1 -7 -15 -15 0
 **/

public class FirstNegativeInteger {
    public static void main(String args[]){
        int T;
        Scanner s = new Scanner(System.in);
        T= s.nextInt();
        for(int t = 0; t< T;t++){
            int N;
            int K;
            int[] elm = new int[10000];
            N = s.nextInt();
            for(int i = 0;i < N;i++){
                elm[i] = s.nextInt();
            }
            K = s.nextInt();
            printFirstNegativeInteger(elm,N,K);
            System.out.println();
        }
    }

    private static void printFirstNegativeInteger(int[] elm,int N,int K){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<K;i++){
            if(elm[i] < 0){
                deque.addLast(elm[i]);
            }
        }
        int windowStart = 1;
        int windowEnd = windowStart + K - 1;
        while (windowEnd <= N-1){
            if(!deque.isEmpty())
                System.out.print(deque.getFirst() + " ");
            else
                System.out.print("0 ");
            if(elm[windowStart-1] < 0 && !deque.isEmpty())
                deque.removeFirst();
            if(elm[windowEnd] < 0) {
                deque.addLast(elm[windowEnd]);
            }
            windowEnd++;
            windowStart++;
        }
        if(!deque.isEmpty())
            System.out.print(deque.getFirst() + " ");
        else
            System.out.print("0 ");
    }
}
