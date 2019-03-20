package com.practice.misc;

import java.util.Scanner;

public class DoesRobotMovesCircular {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t < T;t++){
            String str = s.next();
            if(isCircular(str)){
                System.out.println("Circular");
            }
            else {
                System.out.println("Not Circular");
            }
        }
    }

    public static boolean isCircular(String str){
        int x = 0;
        int y = 0;
        int currentDirection = 0;
        for(int i = 0; i< str.length();i++){
            char c = str.charAt(i);
            if(c == 'G'){
                if(currentDirection == 0)
                    x++;
                else if(currentDirection == 2)
                    x--;
                else if(currentDirection == 1)
                    y++;
                else if(currentDirection == 3)
                    y--;
            }
            if(c == 'L'){
                currentDirection = (currentDirection + 1) % 4;
            }
            if(c == 'R'){
                currentDirection = (currentDirection == 0)?3:(currentDirection - 1) % 4;
            }
        }
        if(x == 0 && y == 0) return true;
        return false;
    }
}
