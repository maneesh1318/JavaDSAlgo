package com.practice.misc;

import java.util.Scanner;

class SeqCounter{
    public static Long count = 0L;
}

public class SubsequencesWithOnlyOneVowel {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(count(str,"",false) % 1000000007);

    }

    public static int count(String str1,String str2,boolean containsVowel){
        if(str1.isEmpty()) {
            return (!str2.isEmpty() && containsVowel)?1:0;
        }
        char c = str1.charAt(0);
        if(!containsVowel){
            if(isVowel(c))
                return count(str1.substring(1), str2 +c ,true) + count(str1.substring(1),str2,false);
            else
                return count(str1.substring(1), str2 +c ,false) + count(str1.substring(1),str2,false);
        }
        else{
            if(isVowel(c))
                return count(str1.substring(1),str2,true);
            else
                return count(str1.substring(1), str2 +c ,true) + count(str1.substring(1),str2,true);
        }

    }

   /* public static int countDP(String s1){
        int[][] dp = new int[s1.length() +1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 0;i< s1.length();i++){
            char c = s1.charAt(i);
            if(isVowel(c)){
                dp[i+1][0] = dp[i][0];
                dp[i+1][1] = dp[i][0] + 1;
            }
            else{
                dp[i+1][0] = dp[i][0    ];
                dp[i+1][1] = dp[i][0] + 1;
            }
        }
    }*/

    private static boolean isVowel(char c){
        return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' ||
                c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
