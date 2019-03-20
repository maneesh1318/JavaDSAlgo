package com.practice.DP;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 30/7/18.
 */
public class problem1 {
    public static void main(String args[]){
        int t,T;
        DecimalFormat df = new DecimalFormat("0.000000");
        Scanner s  = new Scanner(System.in);
        T = s.nextInt();
        for(t =0; t < T; t++){
            int R,G;
            R = s.nextInt();
            G = s.nextInt();
            Double d = probability(R,G);
            System.out.println(df.format(d));

        }
    }

    private static Double probability(int R,int G){
        if(G == 0) return (double)1;
        if(R == 0) return (double)0;
        double [][] dp = new double[1003][1003];
        for(int i=0;i<=R;i++){
            for(int j=0;j<=G;j++){
                if(i==0 && j ==0){
                    dp[i][j] = 1.0;
                    continue;
                }
                if(i==0){
                    dp[i][j] = 1.0;
                    continue;
                }
                if(j==0){
                    dp[i][j] = 1.0;
                    continue;
                }
                if(j == 1){
                    dp[i][j] = (i*1.0)/(i+j);
                    continue;
                }
                dp[i][j] = (i*1.0)/(i+j) + (j*1.0)/(i+j) * (j-1)*1.0/(i+j-1) * dp[i][j-2];
            }
        }
        return dp[R][G];
    }
}
