package com.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordBoggle {
    public static int WHITE = 0;
    public static int GRAY = 1;
    public static int BLACK = 2;
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T  = s.nextInt();
        for(t = 0; t< T; t++){
            int x = s.nextInt();
            String[] d = new String[x];
            for(int i =  0; i< x;i++){
                d[i] = s.next();
            }
            int n = s.nextInt();
            int m = s.nextInt();
            char[][] a = new char[n][m];
            for(int i =0;i< n;i++){
                for(int j =0;j<m;j++){
                    a[i][j] = s.next().charAt(0);
                }
            }
            printWords(d,x,a,n,m);
            System.out.println();
        }
    }

    public static void printWords(String[] d, int x,char[][] a,int n,int m){
        List<String> words = new ArrayList<>();
        for(int i =0;i< n;i++){
            for(int j =0; j < m; j++){
                int[][] color = new int[n][m];
                color[i][j] = 1;
                DFS(a,color,n,m,"" + a[i][j],words,d,i,j);
            }
        }
        words = words.stream().distinct().sorted().collect(Collectors.toList());
        if(words.size() == 0){
            System.out.print("-1");
        }
        for(int i =0;i<words.size();i++){
            System.out.print(words.get(i) + " ");
        }
    }

    public static void DFS(char a[][],int[][] color, int n,int m,String s,List<String> words,String[] d,int u,int v){
        if(contains(d,s)){
            words.add(s);
        }
        for(int i = -1;i<= 1;i++){
            for(int j = -1;j<=1;j++){
                if(i == 0 && v == 0) continue;
                int x = u + i;
                int y = v + j;
                if(x >= 0 && x < n && y >= 0 && y<m && color[x][y] != 1){
                    color[x][y] = 1;
                    DFS(a,color,n,m,s + a[x][y],words,d,x,y);
                    color[x][y] = 0;
                }
            }
        }


    }

    private static boolean contains(String[] d,String s){
        for(int i =0;i<d.length;i++){
            if(d[i].equals(s)) return true;
        }
        return false;
    }


}
