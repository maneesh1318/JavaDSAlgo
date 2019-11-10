/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
package com.newpractice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsStringFollowPattern {
    public static void main(String[] args){
        System.out.println(wordPattern("deadbeef","d e a d b e e f"));
    }

    public static boolean wordPattern(String pattern, String str) {
        char[] characters = pattern.toCharArray();
        String[] strs = str.split(" ");
        Map<Character,String> patternMap = new HashMap<>();
        if(pattern.length() != strs.length){
            return false;
        }
        int i = 0;
        for (char c:characters) {
            if(patternMap.get(c) == null){
                if(patternMap.values().contains(strs[i])){
                    return false;
                }
                patternMap.put(c,strs[i]);
            }
            i++;
        }
        List<String> words = new ArrayList<>();
        for (char c:characters) {
            words.add(patternMap.get(c));
        }
        return  str.equals(words.stream().collect(Collectors.joining(" ")));
    }
}
