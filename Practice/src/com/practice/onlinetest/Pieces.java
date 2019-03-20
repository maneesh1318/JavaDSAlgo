package com.practice.onlinetest;

import java.util.ArrayList;
import java.util.List;

public class Pieces {

}

abstract class TetrisBase{
    int x;
    int y;
    List<Pair> L;

    abstract void generatePiece(int x,int y);
    abstract void updatePiece(int x,int y);
    abstract int getLeftLimitX();
    abstract int getRightLimitX();
    abstract int topLimitY();
    abstract int bottonLimitY();
    abstract List<Pair> getOccupied();
}

class SquarePiece extends TetrisBase{

    SquarePiece(int x,int y){
        this.x = x;
        this.y = y;
        generatePiece(x,y);
    }
    @Override
    void generatePiece(int x, int y) {
        L = new ArrayList<>();
        L.add(new Pair(x,y));
        L.add(new Pair(x + 1,y));
        L.add(new Pair(x ,y + 1));
        L.add(new Pair(x + 1,y + 1));
    }

    @Override
    void updatePiece(int x, int y) {
        L.clear();
        generatePiece(x,y);
    }

    @Override
    int getLeftLimitX() {
        int minX = Integer.MAX_VALUE;
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            minX = Math.min(minX,P.x);
        }
        return minX;
    }

    @Override
    int getRightLimitX() {
        int maxX = Integer.MIN_VALUE;
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            maxX = Math.max(maxX,P.x);
        }
        return maxX;
    }

    @Override
    int topLimitY() {
        return 0;
    }

    @Override
    int bottonLimitY() {
        int maxY = -1;
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            maxY = Math.max(maxY,P.y);
        }
        return maxY;
    }

    public List<Pair> getOccupied(){
        return L;
    }
}

class StraightLinePiece extends TetrisBase{

    @Override
    void generatePiece(int x, int y) {
        L = new ArrayList<>();
        L.add(new Pair(x,y));
        L.add(new Pair(x + 1,y));
        L.add(new Pair(x + 2,y));

    }

    StraightLinePiece(int x,int y){
        this.x = x;
        this.y = y;
        generatePiece(x,y);
    }

    @Override
    void updatePiece(int x, int y) {
        L.clear();
        generatePiece(x,y);
    }

    @Override
    int getLeftLimitX() {
        int minX = Integer.MAX_VALUE;
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            minX = Math.min(minX,P.x);
        }
        return minX;
    }

    @Override
    int getRightLimitX() {
        int maxX = Integer.MIN_VALUE;
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            maxX = Math.max(maxX,P.x);
        }
        return maxX;
    }

    @Override
    int topLimitY() {
        return 0;
    }

    @Override
    int bottonLimitY() {
        int maxY = -1;
        for(int i =0;i<L.size();i++){
            Pair P = L.get(i);
            maxY = Math.max(maxY,P.y);
        }
        return maxY;
    }

    @Override
    List<Pair> getOccupied() {
        return L;
    }
}

class Pair{
    public int x;
    public int y;
    Pair(int x,int y){
        this.x =x;
        this.y = y;
    }
}
