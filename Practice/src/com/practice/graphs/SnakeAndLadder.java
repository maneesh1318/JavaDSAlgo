package com.practice.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadder {
    private final static int WHITE = 0;
    private final static int GRAY = 1;
    private final static int BLACK = 2;

    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t<T;t++){
            int N = s.nextInt();
            int[] move = new int[31];
            Arrays.fill(move,-1);
            for(int i =0;i<N;i++){
                int a = s.nextInt();
                int b = s.nextInt();
                move[a] = b;
            }
            System.out.println(minMoves(move,N));
        }
    }

    private static int minMoves(int[] move,int N){
        LinkedList<Integer> q = new LinkedList<>();
        int[] color = new int[31];
        int[] d = new int[31];
        q.addLast(1);
        color[1] = GRAY;
        while(!q.isEmpty()){
            int u = q.removeFirst();
            for(int i=1;i<=6;i++){
                if(u + i <= 30 && move[u + i] == -1){
                    if(color[u + i] == WHITE) {
                        q.addLast(u + i);
                        color[u + i] = GRAY;
                        d[u+i] = d[u] + 1;
                    }
                }
                else if(u + i <= 30){
                    if(color[move[u+i]] == WHITE){
                        q.addLast(move[u+i]);
                        color[move[u+i]] = GRAY;
                        d[move[u+i]] = d[u] + 1;
                    }
                }
            }
            color[u] = BLACK;
        }
        return d[30];
    }


}
