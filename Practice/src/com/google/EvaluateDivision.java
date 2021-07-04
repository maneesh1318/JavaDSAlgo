package com.google;

public class EvaluateDivision {

    static class Rational {
        double n;
        double d;

        Rational(){
            n = d = 1;
        }

        Rational(double n, double d){
            this.n = n;
            this.d = d;
        }

        public void inverse(){
           double temp = n;
           n = d;
           d = temp;
        }

        public void multiply(Rational rational){
            n *= rational.n;
            d *= rational.d;
        }
    }

    public static void main(String[] args){

    }
}
