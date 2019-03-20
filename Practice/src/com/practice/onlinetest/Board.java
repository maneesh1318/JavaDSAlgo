package com.practice.onlinetest;

public class Board {
    int X;
    int Y;
    int[][] B;

    Board(int X,int Y){
        this.X = X;
        this.Y = Y;
        B = new int[Y][X];
    }

    public void set(int x,int y,int val){
        B[y][x] = val;
    }

    public int get(int x,int y){
        return B[y][x];
    }

    public int getBottomLimit(){
        return Y - 1;
    }

    public int getLeftLimit(){
        return 0;
    }

    public int getRightLimit(){
        return X - 1;
    }

    public int getTopLimit(){
        return 0;
    }

    public void display(){
        for(int y =0;y<Y;y++){
            for(int x =0;x < X;x++){
                System.out.print(B[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void mergeOnes(){
        boolean flag = true;
        while (flag) {
            for (int x = 0; x < X; x++) {
                if (B[Y - 1][x] == 0) flag = false;
            }
            if (flag) {
                for (int x = 0; x < X; x++) {
                    B[Y - 1][x] = 0;
                }
                moveAllPiecesDownByOne();
            }
        }
    }

    private void moveAllPiecesDownByOne(){
        for(int y = Y - 1;y > 0 ;y--){
            for(int x = 0;x < X;x++){
                B[y][x] = B[y-1][x];
            }
        }
    }
}
