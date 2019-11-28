package com.leetcode;

public class RegularExpressionMatching {
    public static void main(String args[]){
        String p = "a.";
        String s = "aa";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()){
            return true;
        }
        else if((s.isEmpty() && !p.isEmpty()) || ((!s.isEmpty() && p.isEmpty()))){
            return false;
        }
        else if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
            return isMatch(s.substring(1),p.substring(1));
        }
        else{
            if(p.length() > 1 && p.charAt(1) == '*'){
                Boolean match = isMatch(s,p.substring(2));

            }
            return false;
        }
    }
}
