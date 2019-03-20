package com.practice.DP;

import java.util.Scanner;

class Count{
    public static int count = 0;
}

public class BooleanParenthisization {
    public static void main(String args[]){
        System.out.println(ways("T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F",true));
        System.out.println(waysDP("T&T|F|F^F^T^T^T&T^F^T&F|F^F^F&F&F|F|F^F^T|T&T") % 1003);
        //System.out.println(ways("T|T",true));
        //System.out.println(ways("T^T",true));
        //System.out.println(ways("T&T&F",false));
       /* int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t=0;t<T;t++){
            int N = s.nextInt();
            String expr = s.next();
            s.nextLine();
            System.out.println(waysDP(expr));
        }*/
    }

    public static int ways(String expr,Boolean val){
        if(expr.isEmpty()){
            System.out.println("Invalid Input");
            return 0;
        }
        if(expr.length() == 1 && expr.equals("T")){
            return (val)?1:0;
        }
        if(expr.length() == 1 && expr.equals("F")){
            return (val)?0:1;
        }
        int ways = 0;
        for(int i =0;i<expr.length();i++){
            if(expr.charAt(i) != 'T' && expr.charAt(i) !='F'){
                String expr1 = expr.substring(0,i);
                String expr2 = expr.substring(i+1);
                if(val) {
                    switch (expr.charAt(i)) {
                        case '|':
                            ways += (ways(expr1, false) * ways(expr2, true)) + (ways(expr1, true) * ways(expr2, false)) + (ways(expr1, true) * ways(expr2, true));
                            continue;
                        case '&':
                            ways += (ways(expr1, true) * ways(expr2, true));
                            continue;
                        case '^':
                            ways += (ways(expr1, true) * ways(expr2, false)) + (ways(expr1, false) * ways(expr2, true));
                            continue;
                    }
                }
                else{
                    switch (expr.charAt(i)) {
                        case '|':
                            ways += (ways(expr1, false) * ways(expr2, false));
                            continue;
                        case '&':
                            ways += (ways(expr1, false) * ways(expr2, false)) + (ways(expr1, true) * ways(expr2, false)) + (ways(expr1, false) * ways(expr2, true));
                            continue;
                        case '^':
                            ways += (ways(expr1, true) * ways(expr2, true)) + (ways(expr1, false) * ways(expr2, false));
                            continue;
                    }
                }
            }
        }
        return ways;
    }

    public static long waysDP(String expr){
        int L = expr.length();
        long[][][] dp = new long[L][L][2];
        for(int l = 1;l<=L;l += 2){
            for(int i = 0;i <= L -l;i +=2){
                int j = i + l - 1;
                long ways0 = 0;
                long ways1 = 0;
                for(int k=i;k<=j;k++){
                    if(l == 1){
                        if(expr.charAt(i) == 'T'){
                            dp[i][j][0] = 0;
                            dp[i][j][1] = 1;
                        }
                        else if(expr.charAt(i) == 'F'){
                            dp[i][j][0] = 1;
                            dp[i][j][1] = 0;
                        }
                        continue;
                    }
                    if(expr.charAt(k) != 'T' && expr.charAt(k) != 'F'){
                        if(expr.charAt(k) == '&'){
                            ways0 += (dp[i][k-1][0] * dp[k+1][j][0]) + (dp[i][k-1][0] * dp[k+1][j][1]) + (dp[i][k-1][1] * dp[k+1][j][0]);
                            ways1 += (dp[i][k-1][1] * dp[k+1][j][1]);
                        }
                        if(expr.charAt(k) == '|'){
                            ways0 += (dp[i][k-1][0] * dp[k+1][j][0]);
                            ways1 += (dp[i][k-1][0] * dp[k+1][j][1]) + (dp[i][k-1][1] * dp[k+1][j][0]) + (dp[i][k-1][1] * dp[k+1][j][1]);
                        }
                        if(expr.charAt(k) == '^'){
                            ways0 += (dp[i][k-1][0] * dp[k+1][j][0]) + (dp[i][k-1][1] * dp[k+1][j][1]);
                            ways1 += (dp[i][k-1][0] * dp[k+1][j][1]) + (dp[i][k-1][1] * dp[k+1][j][0]);
                        }
                    }
                }
                if(l != 1) {
                    dp[i][j][0] = ways0;
                    dp[i][j][1] = ways1;
                }
            }
        }
        return dp[0][expr.length() - 1][1];
    }
}
