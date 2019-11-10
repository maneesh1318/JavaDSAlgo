package com.practice.DP;

public class MinimumPalindromicSubstring {
    public static void main(String args[]){
        System.out.println(minPalindromicSubstring("abakkd"));
        System.out.println(minPalindromicSubstringDP("abakkd"));

    }

    public static int minPalindromicSubstringDP(String str){
        int L = str.length();
        int[][] dp = new int[L][L];
        for(int l = 1; l <= L; l++){
            for(int i = 0; i <= L - l; i++){
                int j = i + l - 1;
                if(l == 1 || isPalindrome(str.substring(i,j+1))) {
                    dp[i][j] = 1;
                    continue;
                }
                int min = L;
                for(int k = i; k < j; k++){
                   min = Math.min(min,dp[i][k] + dp[k+1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][L-1];
    }

    public static int minPalindromicSubstring(String str){
        if(isPalindrome(str)) return 1;
        int min = str.length();
        for(int i = 0; i < str.length() - 1 ;i++){
            min = Math.min(min,minPalindromicSubstring(str.substring(0,i+1)) + minPalindromicSubstring(str.substring(i+1)));
        }
        return min;
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1) return true;
        int mid1,mid2;
        if(s.length() % 2 == 0){
            mid1 = s.length()/2 - 1;
            mid2 = mid1 + 1;
        }
        else{
            mid1 = mid2 = s.length()/2;

        }
        while(mid1 >= 0 && mid2 < s.length()){
            if(s.charAt(mid1) != s.charAt(mid2)) return false;
            mid1--;
            mid2++;
        }
        return true;
    }
}

