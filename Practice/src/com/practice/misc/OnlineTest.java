package com.practice.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class OnlineTest {
    public static void main(String args[]){
        int numDestinations = 3;
        int numDeliveries = 2;
        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0;i<numDestinations;i++){
            l.add(new ArrayList<>());
        }
        l.get(0).add(1);
        l.get(0).add(2);
        l.get(1).add(3);
        l.get(1).add(4);
        l.get(2).add(1);
        l.get(2).add(-1);
        ClosestXdestinations(numDestinations,l,numDeliveries);




    }

    public static List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        allLocations.sort(new lstComp());
        return allLocations.subList(0,numDeliveries);
    }



    public static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        LinkedList<pair> q = new LinkedList<>();
        int color[][] = new int[numRows][numColumns];
        int d[][] = new int[numRows][numColumns];
        q.addLast(new pair(0,0));
        color[0][0] = 1;
        d[0][0] = 0;
        while (!q.isEmpty()){
            pair p = q.removeFirst();
            for(int i = -1;i<= 1;i++){
                for(int j =-1;j<=1;j++){
                    if(i == 0 && j == 0) continue;
                    if(i != 0 && j!= 0) continue;
                    int u = p.i + i;
                    int v = p.j + j;
                    if((u < 0 || u >= numRows) || (v < 0 || v >= numColumns)) continue;
                    if(color[u][v] == 0 && (area.get(u).get(v) == 1 || area.get(u).get(v) == 9)) {
                        color[u][v] = 1;
                        d[u][v] = d[p.i][p.j] + 1;
                        q.addLast(new pair(u,v));
                    }
                }
            }
            color[p.i][p.j] = 2;

        }
        int ret = -1;
        for(int i =0;i<numRows;i++){
            for(int j =0;j<numColumns;j++){
                if(area.get(i).get(j) == 9){
                    if(color[i][j] != 0) ret = d[i][j];
                }
            }
        }
        return ret;
    }


    private static double distance(double x1,double x2,double y1,double y2){
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
    }
}

class lstComp implements Comparator<List<Integer>>{
    @Override
    public int compare(List<Integer> a, List<Integer> b) {
        double d1 = Math.sqrt(Math.pow(a.get(0),2) + Math.pow(a.get(1),2));
        double d2 = Math.sqrt(Math.pow(b.get(0),2) + Math.pow(b.get(1),2));
        if(d1 > d2)
            return 1;
        if(d1 < d2)
            return -1;
        return 0;

    }
}

class pair{
    public int i;
    public int j;
    pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
