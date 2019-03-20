package com.practice.flipkartOnlineTest;

public class BoardImpl implements  Board {
    Cell[][] board;

    BoardImpl(){
        board = new Cell[8][8];
        for(int i = 0 ;i < 8 ;i++){
            for(int j =0; j < 8; j++){
                board[i][j] = new Cell(i,j);
            }
        }
    }

    public void putPiece(int row,int col,String piece){
        char color = piece.charAt(0);
        char type = piece.charAt(1);
        if(type == 'R'){
            Piece pieceObj = new Rook(row,col,(color == 'W')?Color.WHITE:Color.BLACK);
            board[row][col] = new Cell(row,col,pieceObj);
        }
        else if(type == 'B'){

        }
        else if(type == 'H'){

        }
        else if(type == 'K'){

        }
        else if(type == 'Q'){

        }
        else if(type == 'P'){
            Piece pieceObj = new Pawn(row,col,(color == 'W')?Color.WHITE:Color.BLACK);
            board[row][col] = new Cell(row,col,pieceObj);

        }
        else{
            board[row][col] = new Cell(row,col);
        }
    }

    public void movePossible(String piece,String pos1,String pos2){
        int row1 = Integer.valueOf((pos1.substring(0,1)));
        int col1 = Integer.valueOf(pos1.substring(1));
        int row2 = Integer.valueOf(pos2.substring(0,1));
        int col2 = Integer.valueOf(pos2.substring(1));
        Cell c1 = board[row1][col1];
        Cell c2 =  board[row2][col2];
        if(canMove(c1,c2)){
            System.out.println("Valid Move");
        }
        else{
            System.out.println("Invalid Move");
        }
    }

    @Override
    public boolean canMove(Cell position1, Cell position2) {
        PieceBase pieceBase = (PieceBase) position1.getPiece();
        return pieceBase.canMove(position1,position2,board);
    }

    @Override
    public void move(Piece piece, Cell position1, Cell position2) {

    }
}
