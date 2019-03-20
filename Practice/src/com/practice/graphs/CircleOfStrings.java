package com.practice.graphs;

import java.util.*;

public class CircleOfStrings {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t = 0;t < T;t++){
            int N = s.nextInt();
            List<String> L = new ArrayList<>(N);
            for(int i =0;i<N;i++){
                L.add(s.next());
            }
            System.out.println(isChainPossible(L));
        }
    }

    public static int isChainPossible(List<String> L){
        if(L.size() == 1){
            if(L.get(0).length() == 1 || L.get(0).charAt(0) == L.get(0).charAt(L.get(0).length() - 1)){
                return 1;
            }
            else return 0;
        }
        Map<Character, List<String>> M = new LinkedHashMap<>();
        Map<String,List<String>> graph = new LinkedHashMap<>();
        for(int i =0;i<26;i++){
            int c = 'a' + i;
            M.put((char)c,new ArrayList<>());
        }
        for(int i = 0;i<L.size();i++){
            M.get(L.get(i).charAt(0)).add(L.get(i));
        }
        for(int i =0;i<L.size();i++){
            List<String> lr = new ArrayList<>(M.get(L.get(i).charAt(L.get(i).length() - 1)));
            lr.remove(L.get(i));
            graph.put(L.get(i),lr);
        }
        for(int i =0;i<L.size();i++){
            Map<String,Integer> color = new LinkedHashMap<>();
            //color.put(L.get(i),1);
            DFS(graph,color,L.get(i));
            if(allVisited(L,color)) return 1;
        }
        return 0;
    }

    public static void DFS(Map<String,List<String>> graph,Map<String,Integer> color,String vertex){
        List<String> l = graph.get(vertex);
        for (String str:l) {
            if(color.get(str) == null || color.get(str) == 0) {
                color.put(str, 1);
                DFS(graph, color, str);
            }
        }
    }

    public static boolean allVisited(List<String> L,Map<String,Integer> color){
        for(int i =0;i<L.size();i++){
            if(color.get(L.get(i)) == null || color.get(L.get(i)) == 0) return false;
        }
        return true;
    }
}
