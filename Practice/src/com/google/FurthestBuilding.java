package com.google;

public class FurthestBuilding {
    public static void main(String[] args){
        int[] heights = {14,31,19,3} ;//{ 4,2,7,6,9,14,12 };
        int bricks =  0;
        int ladders = 0;
        int output = furthestBuildingRecursive(heights,bricks,ladders,0);
        System.out.println(output);
    }

    public static int furthestBuildingRecursive(int[] heights, int bricks, int ladders, int index) {
        if(index == heights.length - 1){
            return index;
        }
        else if(bricks < 0 || ladders < 0){
            return -1;
        }
        else if(heights[index + 1] <= heights[index]){
            return furthestBuildingRecursive(heights,bricks,ladders,index + 1);
        }
        else if(ladders == 0 && (bricks < (heights[index+1] - heights[index]))){
            return index;
        }
        return Math.max(
                furthestBuildingRecursive(heights,bricks - (heights[index + 1] - heights[index]),ladders,index + 1),
                furthestBuildingRecursive(heights,bricks,ladders - 1,index + 1)
        );
    }

    /*
    public int furtherstBuilding(int[] heights, int bricks, int ladders) {
        int[][] dp = new int[ladders + 1][bricks + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= ladders; i++){
            if()
        }
        return  dp[bricks][ladders];
    }

    */
}
