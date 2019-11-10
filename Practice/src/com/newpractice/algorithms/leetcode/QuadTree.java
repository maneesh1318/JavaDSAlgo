package com.newpractice.algorithms.leetcode;

public class QuadTree {
    public static void main(String[] args){
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        construct(grid);
    }

    public static Node construct(int[][] grid) {
        if(grid.length == 0) return null;
        return constructQuadTree(grid,0,grid.length - 1,0,grid[0].length - 1);
    }

    public static Node constructQuadTree(int[][] grid,int rowStart,int rowEnd,int colStart,int colEnd){
        Node node = new Node();
        if(evaluateIfLeaf(grid,rowStart,rowEnd,colStart,colEnd)){
            node.val = (grid[rowStart][rowEnd] == 0)?false:true;
            node.isLeaf = true;
            return node;
        }
        int rowMid = (rowStart + rowEnd)/2;
        int colMid = (colStart + colEnd)/2;
        node.isLeaf = false;
        node.topLeft = constructQuadTree(grid,rowStart,rowMid,colStart,colMid);
        node.topRight = constructQuadTree(grid,rowStart, rowMid,colMid + 1,colEnd);
        node.bottomLeft = constructQuadTree(grid,rowMid +1 ,rowEnd,colStart, colMid);
        node.bottomRight = constructQuadTree(grid,rowMid + 1, rowEnd,colMid +1, colEnd);
        return node;
    }

    private static boolean evaluateIfLeaf(int[][] grid,int rowStart,int rowEnd,int colStart,int colEnd){
        int elm = grid[rowStart][colStart];
        for(int i = rowStart; i<= rowEnd ; i++){
            for(int j = colStart; j <= colEnd; j++){
                if(grid[i][j] != elm)
                    return false;
            }
        }
        return true;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
