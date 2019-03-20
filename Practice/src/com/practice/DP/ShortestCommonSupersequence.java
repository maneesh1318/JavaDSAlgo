package com.practice.DP;

import java.util.Map;
import java.util.Scanner;

public class ShortestCommonSupersequence {
    public static void main(String args[]){
       int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t < T;t++){
            String s1 = s.next();
            String s2 = s.next();
            System.out.println(shortestCommonSuperSequenceDP(s1,s2));
        }


    }

    public static String shortestCommonSuperSequence(String s1,String s2){
        if(s1.isEmpty()) return s2;
        if(s2.isEmpty()) return s1;
        if(s1.charAt(0) == s2.charAt(0)) return s1.charAt(0) + shortestCommonSuperSequence(s1.substring(1),s2.substring(1));
        else{
            String m1 = s2.charAt(0) + shortestCommonSuperSequence(s1,s2.substring(1));
            String m2 = s1.charAt(0) + shortestCommonSuperSequence(s1.substring(1),s2);
            return (m1.length() < m2.length())? m1:m2;
        }
    }

    public static int shortestCommonSuperSequenceDP(String s1,String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        char[][] print = new char[s1.length() +  1][s2.length() + 1];
        for(int i =0;i<=s1.length();i++){
            for(int j =0;j<=s2.length();j++){
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                }
                else if(i == 0) {
                    dp[i][j] = j;
                    print[i][j] = 'l';
                }
                else if( j== 0) {
                    dp[i][j] = i;
                    print[i][j] = 'u';
                }
                else{
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                        print[i][j] = 'd';
                    }
                    else{
                       if(dp[i-1][j] < dp[i][j-1]){
                            dp[i][j] = 1 + dp[i-1][j];
                           print[i][j] = 'u';
                       }
                       else{
                           dp[i][j] = 1 + dp[i][j-1];
                           print[i][j] = 'l';
                       }
                    }
                }

            }
        }
        //print(print,s1,s2,s1.length(),s2.length());
        return dp[s1.length()][s2.length()];
     }

     public static String print(char[][] print, String s1,String s2,int i,int j){
        if(i == 0 && j == 0) return "";
        if(i == 0) return s2.substring(0,j);
        if(j == 0) return s1.substring(0,i);
        if(print[i][j] == 'd'){
            return print(print,s1,s2,i-1,j-1) + s1.charAt(i-1);
        }
        else if(print[i][j] == 'u'){
            return print(print,s1,s2,i-1,j) + s1.charAt(i - 1);
        }
        else if(print[i][j] == 'l'){
            return print(print,s1,s2,i,j -1) + s2.charAt(j - 1);
        }
        return "";
     }
}
