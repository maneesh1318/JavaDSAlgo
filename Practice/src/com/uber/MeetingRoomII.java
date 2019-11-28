package com.uber;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomII {
    private static class Time implements Comparable<Time>{
        public Integer t;
        public boolean isStart;

        public Time(int t,boolean isStart){
            this.t = t;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            return this.t.compareTo(o.t);
        }
    }
    public static void main(String args[]){
        //int[][] intervals = {{0, 30},{5, 10},{15, 20}};
        int[][] intervals = {{30, 30},{30, 31},{30,30}};
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(int[][] intervals) {
        List<Time> elms = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            elms.add(new Time(intervals[i][0],true));
            elms.add(new Time(intervals[i][1],false));
        }
        elms.sort((u,v) -> {
            if(u.t != v.t)
                return u.t.compareTo(v.t);
            else if(u.isStart){
                return -1;
            }
            else
                return 1;
        });
        int counter = 0;
        int max = 0;
        for(int i = 0;i < elms.size();i++){
            if(elms.get(i).isStart){
                counter++;
            }
            else {
                counter--;
            }
            if(!(i <= elms.size() - 2 && elms.get(i).t == elms.get(i+1).t)){
                max = Math.max(max,counter);
            }
        }
        return max;
    }
}
