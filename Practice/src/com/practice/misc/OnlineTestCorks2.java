package com.practice.misc;

import java.io.*;

public class OnlineTestCorks2 {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String entryTime = "00:00";

        String leavingTime = "01:00";

        int res = findParkingPrice(entryTime, leavingTime);
        int x = 1;
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    static int findParkingPrice(String entryTime, String leavingTime) {
        entryTime = entryTime.trim();
        leavingTime = leavingTime.trim();
        String[] entryParts = entryTime.split(":");
        String[] leavingParts = leavingTime.split(":");
        int entryHour = Integer.valueOf(entryParts[0]);
        int entryMinutes = Integer.valueOf(entryParts[1]);
        int leavingHour = Integer.valueOf(leavingParts[0]);
        int leavingMinutes = Integer.valueOf(leavingParts[1]);
        int minDiff,HourDiff;
        if(leavingMinutes >= entryMinutes) minDiff = leavingMinutes - entryMinutes;
        else{
            leavingHour--;
            leavingMinutes += 60;
            minDiff = leavingMinutes - entryMinutes;
        }
        HourDiff = leavingHour - entryHour;
        int cost = 2;
        if(HourDiff == 1 || (HourDiff == 0 && minDiff > 0)){
            return  cost + 3;
        }
        HourDiff--;
        cost += 3;
        cost = cost + (4 * HourDiff);
        if(minDiff > 0)
            cost = cost + 4;
        return cost;
    }

}
