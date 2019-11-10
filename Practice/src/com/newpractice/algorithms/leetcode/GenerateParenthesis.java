package com.newpractice.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args){
        List<String> strs = generateParenthesis(6);
        for (String str:strs) {
            System.out.println(str);
        }

    }

    public static List<String> generateParenthesis(int n) {
        if(n % 2 == 1){
            return Collections.emptyList();
        }
        List<String> strs = new ArrayList<>();
        generate(strs,"",0,0,0,n);
        return strs;
    }

    private static void generate(List<String> strs,String str, int c,int o,int index, int n){
        if(index == n){
            if(c == o){
                strs.add(str);
            }
            return;
        }
        if(c > o){
            return;
        }
        generate(strs,str + "(",c,o+1,index+1,n);
        generate(strs,str + ")",c+1,o,index+1,n);
    }
}
