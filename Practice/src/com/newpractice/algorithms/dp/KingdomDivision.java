package com.newpractice.algorithms.dp;

import java.util.Scanner;

public class KingdomDivision {

    public static int NUM_OF_WAYS = 0;

    public static void main(){
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int[][] G = new int[n][n];
        int startU,startV;
        for(int i =0; i < n; i++){
            int u = s.nextInt();
            int v = s.nextInt();
            G[u][v] = G[v][u] = 1;
            if(i == 0){
                startU = u;
                startV = v;
            }
        }
    }

    private void noOfWays(int[][] G,int n,int u,int v){

    }




}
