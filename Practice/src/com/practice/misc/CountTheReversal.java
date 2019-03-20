package com.practice.misc;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class CountTheReversal {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T  = s.nextInt();
        for(t = 0; t<T;t++){
            String S;
            S = s.next();
            System.out.println(minReversal(S));
        }

    }

    private static int minReversal(String s){
        Stack<Character> stack = new Stack<>();
        if(s.length() % 2 != 0) return -1;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                if(c == '}'){
                    if(stack.peek() == '{')
                        stack.pop();
                    else
                        stack.push(c);
                }
                else
                    stack.push(c);
            }
        }
        if(s.isEmpty()) return 0;
        double m = 0;
        double n = 0;
        while (!stack.isEmpty()){
            char c = stack.pop();
            if(c == '{') m++;
            else n++;
        }
        return Double.valueOf(Math.ceil(m/2) + Math.ceil(n/2)).intValue();
    }


}
