package com.practice.misc;
/*

Build Lowest Number by Removing n digits from a given number
Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number by removing ‘n’ digits from the string and not changing the order of input digits.
Examples:
Input: str = "4325043", n = 3 Output: "2043" Input: str = "765028321", n = 5 Output: "0221" Input: str = "121198", n = 2 Output: "1118"
 */

import java.util.Observable;
import java.util.Observer;

public class LowestNumber {
    public static Integer N = Integer.MAX_VALUE;
    public static String S = "";
    public static void main(String args[]){
        String s = "121198";
        int n = 2;
        getLowestNmber("",s,s.length() - n);
        System.out.println(LowestNumber.S);

    }

    public static void getLowestNmber(String s1,String s2,int n){
        if(!s1.isEmpty() && s1.length() == n){
            if(Integer.valueOf(s1) < LowestNumber.N) {
                LowestNumber.N = Integer.valueOf(s1);
                LowestNumber.S = s1;
            }
            return;
        }
        if(s2.isEmpty()){
            return;
        }
        getLowestNmber(s1+s2.charAt(0),s2.substring(1),n);
        getLowestNmber(s1,s2.substring(1),n);
    }


}
