package com.practice.misc;

import java.util.Scanner;

public class LongestPalindromeInString {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            String str = s.next();
            System.out.println(longestPalindrome(str));
        }
    }

    private static String longestPalindrome(String s){
        String p = "";
        for(int i =0;i<s.length();i++){
            String p1 = evenLengthPalindrome(s,i);
            String p2 = oddLengthPalindrome(s,i);
            p = (p.length() >= p1.length())?p:p1;
            p = (p.length() >= p2.length())?p:p2;
        }
        if(p.length() == 1) return "" + s.charAt(0);
        return p;
    }

    private static String evenLengthPalindrome(String s,int index){
        if(index == s.length() - 1) return "";
        if(s.charAt(index) != s.charAt(index + 1)) return "";
        int u,v;
        u = index;
        v = index +1;
        while (u >= 0 && v < s.length() && s.charAt(u) == s.charAt(v)){
            u--;
            v++;
        }
        return s.substring(u+1,v);
    }

    private static String oddLengthPalindrome(String s,int index){
        String r = "";
        if(index == 0 || index == s.length() -1) return r + s.charAt(index);
        int u,v;
        u = v = index;
        while(u >= 0 && v < s.length() && s.charAt(u) == s.charAt(v)){
            u--;
            v++;
        }
        return s.substring(u+1,v);
    }
}
