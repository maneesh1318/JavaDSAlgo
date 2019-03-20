package com.practice.graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
    public static int WHITE = 0;
    public static int GRAY = 1;
    public static int BLACK = 2;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int t,T;
        T = s.nextInt();
        for(t =0;t<T;t++){
            int E = s.nextInt();
            int N = s.nextInt();
            ArrayList<Integer>[] graph = new ArrayList[N];
            for(int i =0;i<N;i++){
                graph[i] = new ArrayList<>();
            }
            for(int i =0;i< E;i++){
                int a = s.nextInt();
                int b = s.nextInt();
                graph[a].add(b);
            }
            topoSort(graph,N);
        }
    }

    public static int[] topoSort(ArrayList<Integer> graph[],int N)
    {
        Stack<Integer> s = new Stack<>();
        int[] color = new int[N];
        DFS(graph,0,N,s,color);
        int[] ret = new int[N];
        for(int i = 0;i < N;i++){
            if(color[i] == WHITE)
                DFS(graph,i,N,s,color);
        }
        int index = 0;
        while (!s.isEmpty()){
            ret[index++] = s.pop();
        }
        return ret;
    }

    public static void DFS(ArrayList<Integer> graph[], int node,int N, Stack s, int[] color){
        if(node >= N){
            System.out.println("Invalid Input");
            return;
        }
        color[node] = GRAY;
        for(int i = 0;i<graph[node].size();i++){
            int currNode = graph[node].get(i);
            if(color[currNode] == WHITE)
                DFS(graph,currNode,N,s,color);
        }
        color[node] = BLACK;
        s.push(node);
        return;
    }
}
