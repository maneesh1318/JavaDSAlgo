package com.practice.flipkartOnlineTest;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends PieceBase {

    Pawn(int row,int col,Color color){
        super(row,col,PieceType.PAWN,color);
    }
    @Override
    public boolean canMove(Cell postion1, Cell position2, Cell[][] board) {
        PieceBase piece = (PieceBase) postion1.getPiece();
        int row = piece.row;
        int col = piece.column;
        List<Cell> places = new ArrayList<>();
        if(piece.color == Color.BLACK){
            Cell c1 = null,c2 = null,c3 = null;
            if(row != 0) {
                c1 = board[row - 1][col];
            }
            if(col != 0){
                c2 = board[row - 1][col - 1];
            }
            if(col != 7){
                c3 = board[row - 1][col + 1];
            }
            if(c1 != null){
                PieceBase pieceC1 = (PieceBase) c1.getPiece();
                if(pieceC1 == null) places.add(c1);
            }
            if(c2 != null){
                PieceBase pieceC2 = (PieceBase) c2.getPiece();
                if(pieceC2 != null && pieceC2.getColor() == Color.WHITE) places.add(c2);
            }
            if(c3 != null){
                PieceBase pieceC3 = (PieceBase) c3.getPiece();
                if(pieceC3 != null && pieceC3.getColor() == Color.WHITE) places.add(c3);
            }
        }
        else if(piece.color == Color.WHITE){
            Cell c1 = null,c2 = null,c3 = null;
            if(row != 7) {
                c1 = board[row + 1][col];
            }
            if(col != 0){
                c2 = board[row + 1][col - 1];
            }
            if(col != 7){
                c3 = board[row + 1][col + 1];
            }
            if(c1 != null){
                PieceBase pieceC1 = (PieceBase) c1.getPiece();
                if(pieceC1 == null) places.add(c1);
            }
            if(c2 != null){
                PieceBase pieceC2 = (PieceBase) c2.getPiece();
                if(pieceC2 != null && pieceC2.getColor() == Color.BLACK) places.add(c2);
            }
            if(c3 != null){
                PieceBase pieceC3 = (PieceBase) c3.getPiece();
                if(pieceC3 != null && pieceC3.getColor() == Color.BLACK) places.add(c3);
            }
        }
        for(int i = 0; i < places.size(); i++){
            if(position2.row == places.get(i).row && position2.col == places.get(i).col) return true;
        }
        return false;
    }
}
