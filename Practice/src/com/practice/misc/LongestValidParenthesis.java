package com.practice.misc;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t = 0; t < T; t++){
            String str = s.next();
            System.out.println(longestValidParentheses(str));
        }
    }

        public static int longestValidParentheses(String s){
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int length = 0;
            int maxLength = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push(i);
                }
                if(s.charAt(i) == ')' && !stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty()){
                        length = i - stack.peek();
                        maxLength = Math.max(length,maxLength);
                    }
                    else{
                        stack.push(i);
                    }
                }
            }
            return maxLength;
        }
}
