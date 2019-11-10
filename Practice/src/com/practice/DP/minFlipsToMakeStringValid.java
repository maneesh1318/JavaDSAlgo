package com.practice.DP;

public class minFlipsToMakeStringValid {
    public static void main(String args[]){
        System.out.println(minFlips("}{",0,0));
        System.out.println(minFlipsDP("}{"));

    }

    public static int minFlips(String s,int k,int open){
        if(k == s.length())
            return open/2;
        if(open == 0){
            if(s.charAt(k) == '{'){
                return minFlips(s,k+1,open+1);
            }
            else{
                return 1 + minFlips(s,k+1,open+1);
            }
        }
        if(s.charAt(k) == '{'){
            return Math.min(1+minFlips(s,k+1,open-1),minFlips(s,k+1,open+1));
        }
        else{
            return Math.min(1+ minFlips(s,k+1,open+1),minFlips(s,k+1,open-1));
        }
    }

    public static int minFlipsDP(String s){
        int L = s.length();
        int[][] dp = new int[L+1][L+2];
        for(int i = L;i>=0;i--){
            for(int j = 0;j <= L; j++){
                if(i == L){
                    dp[i][j] = j/2;
                    continue;
                }
                if(j == 0){
                    if(s.charAt(i) == '{'){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else{
                        dp[i][j] = 1 + dp[i+1][j+1];
                    }
                }
                else{
                    if(s.charAt(i) == '{'){
                        dp[i][j] = Math.min(1+dp[i+1][j-1],dp[i+1][j+1]);
                    }
                    else{
                        dp[i][j] = Math.min(1 + dp[i+1][j+1],dp[i+1][j-1]);
                    }
                }
            }

        }

        return dp[0][0];
    }
}
