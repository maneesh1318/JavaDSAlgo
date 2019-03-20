package com.practice.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindWhetherPathExists {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t<T;t++){
            int N = s.nextInt();
            int si = -1,sj = -1;int di =-1,dj =-1;
            int[][] m = new int[N][N];
            for(int i =0;i<N;i++){
                for(int j =0;j<N;j++){
                    m[i][j] = s.nextInt();
                    if(m[i][j] == 1){
                      si = i;
                      sj = j;
                    }
                    if(m[i][j] == 2){
                        di = i;
                        dj = j;
                    }
                }
            }
            System.out.println(pathExists(m,N,si,sj,di,dj));
        }
    }

    public static int pathExists(int m[][],int N,int si,int sj,int di,int dj){
        if(si == -1 || sj == -1) {
            System.out.println("Invalid Input");
            return 0;
        }
        LinkedList<Pair> q = new LinkedList<>();
        int color[][] = new int[N][N];
        q.addLast(new Pair(si,sj));
        color[si][sj] = 1;
        while (!q.isEmpty()){
            Pair p = q.removeFirst();
            for(int i = -1;i<= 1;i++){
                for(int j =-1;j<=1;j++){
                    if(i == 0 && j == 0) continue;
                    if(i != 0 && j!= 0) continue;
                    int u = p.i + i;
                    int v = p.j + j;
                    if((u < 0 || u >= N) || (v < 0 || v >= N)) continue;
                    if(color[u][v] == 0 && (m[u][v] == 3 || m[u][v] == 2)) {
                        color[u][v] = 1;
                        q.addLast(new Pair(u,v));
                    }
                }
            }
            color[p.i][p.j] = 2;
        }
        return (color[di][dj] == 0)?0:1;
    }
}

class Pair{
    public int i;
    public int j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
