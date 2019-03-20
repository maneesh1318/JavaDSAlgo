package com.practice.flipkartOnlineTest;

public class Cell {
    int row;
    int col;
    Piece piece;

    Cell(int row,int col){
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    Cell(int row,int col,Piece piece){
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
