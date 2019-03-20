package com.practice.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem4 {
    public static void main(String args[]){
        int N;
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        List<Integer> A = new ArrayList<>(N);
        for(int i=0;i<N;i++){
            A.add(s.nextInt());
        }
        //Pair[][] dp = new Pair[20000][20000];
        int count = 0;
        Pair P = new Pair(0,0);
        for(int i=0;i<N;i++){
            for(int j = i;j<N;j++){
                if(i == j){
                    if(A.get(i) % 2 == 0)
                        P.set(1,0);
                    else
                        P.set(0,1);
                }
                else{
                    if(A.get(j) % 2 == 0) {
                        P.setEven(P.getEven() + 1);
                    }
                    else {
                        P.setOdd(P.getOdd() + 1);
                    }

                }
                if(P.isEqual()) count++;
            }
            P.reset();
        }
        System.out.println(count);


    }
}

class Pair{
    private int even;
    private int odd;
    Pair(int even,int odd){
        this.even = even;
        this.odd = odd;
    }
    Pair(Pair P){
        this.even = P.even;
        this.odd = P.odd;
    }
    boolean isEqual(){
        return even == odd;
    }

    public int getEven(){
        return even;
    }

    public int getOdd(){
        return odd;
    }

    public void setEven(int even) {
        this.even = even;
    }

    public void setOdd(int odd) {
        this.odd = odd;
    }

    public void reset(){
        even = 0;
        odd = 0;
    }

    public void set(int even,int odd){
        this.even = even;
        this.odd = odd;
    }
}
