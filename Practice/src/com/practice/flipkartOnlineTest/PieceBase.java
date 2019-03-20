package com.practice.flipkartOnlineTest;

public abstract class PieceBase implements Piece {
    int row;
    int column;
    PieceType type;
    Color color;

    public PieceBase(int row, int column, PieceType type, Color color) {
        this.row = row;
        this.column = column;
        this.type = type;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Color getColor() {
        return color;
    }

    public PieceType getType() {
        return type;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(PieceType type) {
        this.type = type;
    }
}
