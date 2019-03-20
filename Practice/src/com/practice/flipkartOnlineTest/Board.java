package com.practice.flipkartOnlineTest;

public interface Board {
    void putPiece(int row,int col,String piece);
    boolean canMove(Cell position1, Cell position2);
    void move(Piece piece, Cell position1, Cell position2);
}
