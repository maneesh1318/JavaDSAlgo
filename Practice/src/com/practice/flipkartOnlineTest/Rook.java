package com.practice.flipkartOnlineTest;

public class Rook extends PieceBase {

    Rook(int row,int col,Color color){
        super(row,col,PieceType.ROOK,color);
    }
    @Override
    public boolean canMove(Cell postion1, Cell position2, Cell[][] board) {
        return false;
    }
}
