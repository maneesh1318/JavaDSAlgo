package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }

    private static int lengthOfLongestSubstring(String s){
        int i,j;
        Map<Character,Integer> map = new HashMap();
        i = j = 0;
        int maxLength = 0;
        int length = 0;
        while(i < s.length() && j < s.length()){
            if(map.get(s.charAt(j)) == null || map.get(s.charAt(j)) < i){
                length = j - i + 1;
                maxLength = Math.max(length,maxLength);
                map.put(s.charAt(j),j);
                j++;
            }
            else {
                i = map.get(s.charAt(i)) + 1;
            }
        }
        return maxLength;
    }
}
