package com.practice.DP;

import java.util.Scanner;

public class WaysToArrangeBalls {
    public static void main(String args[]){
        int t,T;
        Scanner s = new Scanner(System.in);
        T = s.nextInt();
        for(t =0;t<T;t++){
            int P,Q,R;
            P = s.nextInt();
            Q = s.nextInt();
            R = s.nextInt();
            System.out.println(Ways(P,Q,R,null));
        }
    }

    public static int Ways(int P,int Q,int R,Character prev){
        if(P < 0 || Q < 0 || R < 0) return 0;
        if(P == 0 && Q == 0 && R == 0) return 0;
        else if(P != 0 && Q == 0 && R == 0) return 1;
        else if(P == 0 && Q != 0 && R == 0) return 1;
        else if(P == 0 && Q == 0 && R != 0) return 1;
        else if(P == 0){
            if(Q == R) return 2;
            else if(Math.abs(Q - R) == 1) return 1;
            else return 0;
        }
        else if(Q == 0){
            if(P == R) return 2;
            else if(Math.abs(P - R) == 1) return 1;
            else return 0;
        }
        else if(R == 0){
            if(P == Q) return 2;
            else if(Math.abs(P - Q) == 1) return 1;
            else return 0;
        }
        else if(prev !=null && prev == 'P'){
            return Ways(P,Q-1,R,'Q') + Ways(P,Q,R-1,'R');
        }
        else if(prev !=null && prev == 'Q'){
            return Ways(P-1,Q,R,'P') + Ways(P,Q,R-1,'R');
        }
        else if(prev !=null && prev == 'R'){
            return Ways(P -1,Q,R,'P') + Ways(P,Q -1,R,'Q');
        }
        return Ways(P-1,Q,R,'P') + Ways(P,Q -1,R,'Q') + Ways(P,Q,R-1,'R');
    }
}


