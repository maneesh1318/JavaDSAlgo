package com.practice.graphs;

import java.util.*;

public class AlienDictionary {
    public static int WHITE = 0;
    public static int GRAY = 1;
    public static int BLACK = 2;
    public static void main(String args[]){
        int k = 3;
        String[] Dict = { "caa", "aaa", "aab" };
        System.out.println(printOrder(Dict,Dict.length,k));
    }

    public static String printOrder(String[] dict, int N, int k)
    {
        Map<Character,ArrayList<Character>> graph = new LinkedHashMap<>();
        for(int i=0; i <= N-2; i++){
            String word1 = dict[i];
            String word2 = dict[i+1];
            int u = 0;
            int v = 0;
            while (u < word1.length() && v < word2.length()){
                if(word1.charAt(u) != word2.charAt(v)){
                    if(graph.get(u) == null) graph.put(word1.charAt(u),new ArrayList<>());
                    graph.get(word1.charAt(u)).add(word2.charAt(v));
                    break;
                }
                else{
                    u++;
                    v++;
                }
            }
        }
        return topologicalSort(graph,k);
    }

    private static String topologicalSort(Map<Character,ArrayList<Character>> graph,int k){
        Set<Character> keys = graph.keySet();
        for(Character key:keys){
            Stack<Character> s = new Stack<>();
            Map<Character,Integer> color = new LinkedHashMap<>();
            DFS(graph,key,k,s,color);
            if(s.size() == k){
                String str = "";
                while (!s.isEmpty())
                    str += s.pop();
                return str;
            }
        }
        return "";
    }

    private static void DFS(Map<Character,ArrayList<Character>> graph, Character node, int k, Stack<Character> s, Map<Character,Integer> color){
        if(color.get(node) == null || color.get(node) == 0)
            color.put(node,1);
        List<Character> l = graph.get(node);
        for(int i =0;l !=null && i<l.size();i++){
            if(color.get(l.get(i)) == null || color.get(l.get(i)) == 0){
                DFS(graph,l.get(i),k,s,color);
            }
        }
        s.push(node);
        return;
    }
}
