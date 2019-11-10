package com.newpractice.algorithms.leetcode;

public class NumberOfIslands {
    public static void main(String[] args){
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    DFS(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void DFS(char[][] grid,int m,int n){
        grid[m][n] = '2';
        int M = grid.length;
        int N = grid[0].length;
        if(n - 1 >= 0 && grid[m][n-1] == '1'){
            DFS(grid, m,n -1);
        }
        if(n + 1 < N && grid[m][n + 1] == '1'){
            DFS(grid,m, n + 1);
        }
        if(m - 1 >= 0 && grid[m -1][n] == '1'){
            DFS(grid,m-1,n);
        }
        if(m + 1 < M && grid[m+1][n] == '1'){
            DFS(grid,m + 1, n);
        }
    }


}
