package com.practice.DP;

import java.util.Scanner;

public class Problem8 {
    private static final int INSERT = 1;
    private static final int DELETE = 1;
    private static final int REPLACE = 1;
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int l1 = s.nextInt();
            int l2 = s.nextInt();
            String s1 = s.next();
            String s2 = s.next();
            s.nextLine();
            System.out.println(editDistance(s1,s2));

        }
    }

    public static int editDistance(String s1,String s2){
        int [][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for(int i = 1;i<=s1.length();i++){
            dp[i][0] = dp[i-1][0] + DELETE;
        }
        for(int j = 1;j<=s2.length();j++){
            dp[0][j] = dp[0][j-1] + INSERT;
        }
        for(int i = 1;i<=s1.length();i++){
            for(int j = 1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = min(dp[i-1][j] + INSERT,dp[i][j-1]+DELETE, dp[i-1][j-1]+REPLACE);
                }

            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static int min(int a,int b,int c){
        if(a < b && a < c) return a;
        if(b < a && b < c) return b;
        else return c;
    }
}
