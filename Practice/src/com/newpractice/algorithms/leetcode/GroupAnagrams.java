package com.newpractice.algorithms.leetcode;

/*
Given an array of strings, group anagrams together.

        Example:

        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String args[]){
        String[] strs = {"eat","tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groups = groupAnagrams(strs);
        int x = 1;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groups = new LinkedHashMap<>(strs.length);
        for (String str:strs) {
            char[] key = str.toCharArray();
            Arrays.sort(key);
            mapPut(groups,new String(key),str);
        }

        return groups.values().stream().collect(Collectors.toList());
    }

    private static void mapPut(Map<String,List<String>> groups,String key, String value){
        if(groups.get(key) == null){
            List<String> val = new ArrayList<>();
            val.add(value);
            groups.put(key,val);
        }
        else {
            groups.get(key).add(value);
        }
    }
}
