package com.practice.flipkartOnlineTest;

import java.util.Scanner;

public class Game {
    public static void main(String args[]){
        Board board = new BoardImpl();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Board Configuration");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board.putPiece(i,j,s.next());
            }
        }
        System.out.println("Enter Number of Moves");
        int T = s.nextInt();
        for(int t = 0 ; t < T;t++){
            String piece = s.next();
            String pos1 = s.next();
            String pos2 = s.next();
            ((BoardImpl) board).movePossible(piece,pos1,pos2);
        }

    }
}
