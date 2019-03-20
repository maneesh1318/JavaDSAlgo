package com.practice.misc;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringChaining {
   public static void main(String args[]){
       String[] str = {"for", "geek", "rig", "kaf"};
       if(canBeChained(str))
        System.out.println("Can be Chained");
       else
           System.out.println("Can not be Chained");
   }

   public static boolean canBeChained(String[] str){
        Map <Character,String> M = new LinkedHashMap<>(str.length);
        Map <Character,Integer> V = new LinkedHashMap<>(str.length);
        for(int i = 0;i<str.length;i++){
            M.put(str[i].charAt(0),str[i]);
            V.put(str[i].charAt(0),0);
        }
        char first = str[0].charAt(0);
        dfs(M,first,V);
        Boolean toRet = true;
        for(Character key: V.keySet()){
            Integer val = V.get(key);
            if(val == 0) return false;
        }
       return true;

   }

   public static void dfs(Map<Character,String> M,Character n,Map<Character,Integer> visited){
       if(visited.get(n) == 1)
           return;
       visited.put(n,1);
       Character nextNode = M.get(n).charAt(M.get(n).length() - 1);
       dfs(M,nextNode,visited);
   }
}
