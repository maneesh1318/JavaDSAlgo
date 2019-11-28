package com.uber;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExclusiveTimeOfFunctions {

    public static void main(String args[]){
        String[] arr = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        List<String> logs = Arrays.asList(arr);
        Solution solution = new Solution();
        int[] result = solution.exclusiveTime(2,logs);
        int x = 1;

    }


}

class Solution{
    private class Event{
        public int id;
        public int time;
        public boolean isStart;
        public int elapsedTime = 0;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] arr = new int[n];
        Stack<Event> history = new Stack<>();
        List<Event> logList = logs.stream().map(this::getEvent).collect(Collectors.toList());
        for (Event e:logList) {
            if(e.isStart) {
                history.push(e);
            }
            else{
                Event event = history.pop();
                arr[e.id] += (e.time - event.time + 1) - event.elapsedTime;
                if(!history.isEmpty()){
                    history.peek().elapsedTime += (e.time - event.time + 1);
                }
            }
        }
        return arr;
    }

    private Event getEvent(String str){
        if(str.isEmpty())
            return null;
        String[] parts = str.split(":");
        Event evt = new Event();
        evt.id = Integer.valueOf(parts[0]);
        evt.time = Integer.valueOf(parts[2]);
        evt.isStart = (parts[1].equals("start"))?true:false;
        return evt;
    }

}
