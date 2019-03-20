package com.practice.DP;

import java.util.Scanner;

public class Problem6 {
    public static void main(String args[]){
        int T,t;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t<T;t++){
            String str = s.next();
            int o = maxLengthPalindrome(str);
            //System.out.println(o);
            if(isPrime(o))
                System.out.println("PRIME");
            else
                System.out.println("NOT PRIME");
        }

    }

    private static int maxLengthPalindrome(String s){
        int l = s.length();
        int max = 0;
        for(int i=0;i<l;i++){
            for(int j = i;j<l;j++){
                if(isPalindrome(s,i,j) && (j-i+1) > max){
                     max = j - i + 1;
                }
            }
        }
        return max;
    }

    private static boolean isPrime(int N){
        if(N == 2 | N ==3) return true;
        for(int i = 2;i<= (int)(Math.pow(N,0.5) +1);i++){
            if(N % i == 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(String str,int i,int j){
        while(i <=j){
            if(str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }


}
