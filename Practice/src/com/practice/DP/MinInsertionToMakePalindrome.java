package com.practice.DP;

import java.util.Scanner;

public class MinInsertionToMakePalindrome {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0 ; t < T; t++){
            String str = s.next();
            System.out.println(minCharacterDP(str));
        }
    }

    public static int minCharacter(String str){
        if(str == null) return 0;
        if(str.length() == 0 || str.length() == 1)
            return 0;
        if(str.charAt(0) == str.charAt(str.length()-1))
            return minCharacter(str.substring(1,str.length()-1));
        int a = minCharacter(str.substring(1));
        int b = minCharacter(str.substring(0,str.length() - 1));
        return Math.min(a,b) + 1;
    }

    public static int minCharacterDP(String str){
        int L = str.length();
        int[][] dp = new int[L][L];
        for(int l = 1; l <= L; l++){
            for (int i = 0; i <= L - l;i++){
                int j = i + l - 1;
                if(l == 1){
                    dp[i][j] = 0;
                    continue;
                }
                for(int k = i; k <= j;k++){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1]) + 1;
                    }
                }
            }
        }
        return dp[0][L-1];
    }
}
