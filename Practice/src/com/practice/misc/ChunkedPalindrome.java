package com.practice.misc;

import java.util.Scanner;

/**
 * Created by Manish Richhariya(manish.richhariya@99acres.com) on 8/7/18.
 */
public class ChunkedPalindrome {
    public static void main(String args[]){
        String str;
        Scanner s = new Scanner(System.in);
        str = s.nextLine();
        System.out.println(longestChunkedPalindromeLength(str));

    }

    private static int longestChunkedPalindromeLength(String str){
        if(str == null || str.length() == 0)
            return 0;
        char c = str.charAt(0);
        if(str.indexOf(c) == str.lastIndexOf(c))
            return 1;
        String str1 = str.substring(str.lastIndexOf(c));
        String str2 = str.substring(0,str1.length());
        if(str1.equals(str2)){
            return 2 + longestChunkedPalindromeLength(str.substring(str1.length(),str.lastIndexOf(c)));
        }
        return 1;
    }


}
