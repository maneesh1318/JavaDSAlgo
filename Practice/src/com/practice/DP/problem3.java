package com.practice.DP;

import java.util.Scanner;

public class problem3 {
    public static void main(String args[]){
        String str;
        Scanner s = new Scanner(System.in);
        str = s.nextLine();
        int []dp = new int[10004];
        int len = str.length();
        if((str.charAt(len-1) - '0') % 2 == 0) dp[len-1] = 1;
        else dp[len-1] = 0;
        for(int i = str.length() - 2;i >= 0;i--){
            if((str.charAt(i) - '0') % 2 == 0) dp[i] = dp[i+1] +1;
            else dp[i] = dp[i + 1];
        }
        for(int i =0;i<str.length();i++){
            System.out.print(dp[i] + " ");
        }
    }
}
