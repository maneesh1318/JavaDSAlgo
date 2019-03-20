package com.practice.DP;

public class TomAndJerry {
    public static void main(String args[]){
        System.out.println(game(3,"Tom"));

    }

    public static String game(int N,String turn){
        if(N == 1 && turn == "Tom"){
            return "Jerry";
        }
        else if(N == 1 && turn == "Jerry"){
            return "Tom";
        }
        if(turn == "Tom"){
            for(int i = 1; i <= (int)Math.sqrt(N);i++){
                if(N % i == 0){
                    if(game(N-i,"Jerry") == "Tom") return "Tom";
                }
            }
            return "Jerry";
        }
        if(turn == "Jerry"){
            for(int i = 1; i <= (int)Math.sqrt(N);i++){
                if(N % i == 0){
                    if(game(N-i,"Tom") == "Jerry") return "Jerry";
                }
            }
            return "Tom";
        }
        return "";
    }
}
