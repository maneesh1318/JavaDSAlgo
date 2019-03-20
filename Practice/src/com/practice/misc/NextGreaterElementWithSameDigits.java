package com.practice.misc;

import java.util.Arrays;

public class NextGreaterElementWithSameDigits {
    public static void main(String args[]){
        String number  = "534976";
        number = nextGreaterNumber(number);
        System.out.println(number);
    }

    public static String nextGreaterNumber(String number){
        int[] digits = new int[number.length()];
        for(int i = 0; i < number.length(); i++){
            digits[i] = number.charAt(i) - '0';
        }
        int i = digits.length - 1;
        while (i > 0 && digits[i - 1] > digits[i]){
            i--;
        }
        i--;
        if(i <= 0) return "Not Possible";
        int minDigit = 10;
        int minDigitIndex = -1;
        for(int j = i + 1;j<digits.length;j++){
            if(digits[j] > digits[i] && digits[j] < minDigit){
                minDigit = digits[j];
                minDigitIndex = j;
            }
        }
        int temp = digits[minDigitIndex];
        digits[minDigitIndex] = digits[i];
        digits[i] = temp;
        Arrays.sort(digits,i+1,digits.length);
        String str = "";
        for(int j = 0;j<digits.length;j++)
            str += digits[j];
        return str;
    }
}
