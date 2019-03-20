package com.practice.onlinetest;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String args[]){
        Game game = new Game(6,7);
        game.generatePieceAt(0,0,TYPE.STRAIGH);
        game.simulateBottomMovement();
        game.generatePieceAt(2,0,TYPE.SQUARE);
        game.simulateBottomMovement();
        game.generatePieceAt(3,0,TYPE.SQUARE);
        game.simulateBottomMovement();
        game.generatePieceAt(0,0,TYPE.SQUARE);
        game.simulateBottomMovement();

        game.generatePieceAt(4,0,TYPE.SQUARE);
        //game.simulateBottomMovement();

    }

}

enum TYPE{
    SQUARE,STRAIGH;
}

class Game{
    Board board;
    TetrisBase currPiece;
    int curPieceX;
    int curPieceY;

    Game(int X,int Y){
        board = new Board(X,Y);
    }

    void generatePieceAt(int x,int y,Enum type){
        if(type == TYPE.SQUARE){
            currPiece = new SquarePiece(x,y);
        }
        if(type == TYPE.STRAIGH){
            currPiece = new StraightLinePiece(x,y);
        }
        if(!validatePiece(x,y)){
            System.out.println("Piece cannot be generated at this point");
            currPiece = null;
            return;
        }
        curPieceX = x;
        curPieceY = y;
        updateBoard();
        displayState();
        return;
    }

    void simulateBottomMovement(Integer t){

    }

    boolean validatePiece(int x,int y){
        /*if((x < 0 || x > board.getRightLimit() )|| (y < 0 || y > board.getBottomLimit())){
            return false;
        }*/
        int pieceLeftLimit = currPiece.getLeftLimitX();
        int pieceRightLimit = currPiece.getRightLimitX();
        int pieceBottonLimit = currPiece.bottonLimitY();
        if(pieceLeftLimit < board.getLeftLimit() || pieceRightLimit > board.getRightLimit() || pieceBottonLimit > board.getBottomLimit())
            return false;
        return true;

    }

    void simulateBottomMovement(){
        int y = 0;
        while (canMoveDown(y)){
            y++;
            clearBoard();
            currPiece.updatePiece(curPieceX,y);
            updateBoard();
            board.display();
        }
        board.mergeOnes();
        board.display();
    }

    private boolean canMoveDown(int y){
        if(y <= board.getBottomLimit() && currPiece.bottonLimitY() < board.getBottomLimit() && isBottonLineFree(y)){
            return true;
        }
        return false;
    }

    private boolean isBottonLineFree(int y){
        for(int x = currPiece.getLeftLimitX(); x <= currPiece.getRightLimitX(); x++){
            if(board.get(x,currPiece.bottonLimitY() + 1) == 1) return false;
        }
        return true;
    }

    void updateBoardTemporary(){

    }

    void updateBoard(){
        List<Pair> L = currPiece.getOccupied();
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            board.set(P.x,P.y,1);
        }

    }

    void clearBoard(){
        List<Pair> L = currPiece.getOccupied();
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            board.set(P.x,P.y,0);
        }

    }

    void displayState(){
        board.display();
    }

}
