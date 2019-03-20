package com.practice.misc;

import java.util.Scanner;

public class MusicOrVideo {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        for(int i =0;i<N;i++){
            String input = s.nextLine();
            String[] parts = input.split(" ");
            if(parts.length == 2){
                if(isValid(parts[0],parts[1]))
                    System.out.println("M");
                else
                    System.out.println("N");

            }
            else if(parts.length == 3){
                if(isValid(parts[0],parts[1],parts[2]))
                    System.out.println("V");
                else
                    System.out.println("N");

            }
            else{
                System.out.println("N");
            }
        }
    }

    private static boolean isValid(String a,String b){
        if(isValidName(a) && isValidInteger(b))
            return true;
        return false;

    }

    private static boolean isValid(String a,String b,String c){
        if(isValidName(a) && isValidInteger(b) && isValidInteger(c))
            return true;
        return false;
    }

    private static boolean isValidInteger(String s){
        for(int i =0;i<s.length();i++){
            int c = s.charAt(i) - '0';
            if(i == 0 && c == 0) return false;
            if(c < 0 || c > 9) return false;
        }
        return true;
    }

    private static boolean isValidName(String s){
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) return true;
        }
        return false;
    }


}
