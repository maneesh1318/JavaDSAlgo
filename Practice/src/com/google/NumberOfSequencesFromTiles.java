package com.google;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NumberOfSequencesFromTiles {
    public static void main(String[] args){
        String  tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        Map<String,Integer> strs = new LinkedHashMap<>();
        count("",tiles,0,tiles.length(),strs);
        int total = 0;
        for (String key : strs.keySet()){
            Set<Character> C = new HashSet<>();
            for (Character c:key.toCharArray()) {
                C.add(c);
            }
        }
        return 0;
    }

    private static void count(String seq,String tiles,int currIndex,int length, Map<String,Integer> strs){
        if(currIndex == length){
           strs.put(seq,1);
           return;
        }
        count(seq,tiles,currIndex + 1, length,strs);
        count(seq + tiles.charAt(currIndex),tiles,currIndex+1,length,strs);
    }


}
