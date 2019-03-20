package com.practice.misc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RearrangeCharactersNoAdjacentSame {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        s.nextLine();
        for(t =0;t<T;t++){
            String str = s.nextLine();
            System.out.println(isPossible(str)?"1":"0");

        }
    }

    public static boolean isPossible(String str){
        if(str == null || str.isEmpty())
            return true;
        Map<Character,Integer> charMap = new LinkedHashMap(26);
        for(int i =0;i< str.length();i++){
            char c = str.charAt(i);
            if(charMap.get(c) == null) charMap.put(c,1);
            else charMap.put(c,charMap.get(c) + 1);
        }
        int S = 0;
        int max = Integer.MIN_VALUE;
        for(Character key: charMap.keySet()){
            max = Math.max(max,charMap.get(key));
            S += charMap.get(key);
        }
        int remaining = S - max;
        if(remaining + 1 >= max) return true;
        return false;
    }


}
