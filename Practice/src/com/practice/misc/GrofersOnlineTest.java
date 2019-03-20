package com.practice.misc;

import java.util.Scanner;

public class GrofersOnlineTest {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        permutations(getString(n).toCharArray(),0);
    }

    public static void permutations(char[] s,int index){
        if(index == s.length - 1) {
            System.out.println(String.valueOf(s));
            return;
        }
        for(int i = index;i < s.length;i++){
            char temp = s[index];
            s[index] = s[i];
            s[i] = temp;
            permutations(s,index + 1);
            temp = s[index];
            s[index] = s[i];
            s[i] = temp;

        }

    }

    public static String getString(int n){
        String s = "";
        char c = 'a';
        for(int i = 0;i < n;i++){
            s = s + (char)(c + i);
        }
        return s;
    }
}
