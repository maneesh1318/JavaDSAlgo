package com.practice.misc;

import java.text.DecimalFormat;

public class PriceFormator {

    public static void main(String args[]){
        String budgetStr = "15+Crore";
        System.out.println(convertBudgetString(budgetStr));
    }

    public static String convertBudgetString(String budgetStr){
        String priceStr = null;
        if(budgetStr == null || budgetStr.isEmpty()) return null;
        Integer price = Integer.valueOf(budgetStr.replaceAll("[^0-9,.]",""));
        if(budgetStr.contains("Cr") || budgetStr.contains("cr") || budgetStr.contains("Crore") || budgetStr.contains("crore")){
            price = price * 10000000;
        }
        if(budgetStr.contains("l") || budgetStr.contains("L") || budgetStr.contains("Lac") || budgetStr.contains("Lacs")){
            price = price * 100000;
        }
        return price.toString();
    }



    public static String formatNumberIndianStyle(String number)
    {
        DecimalFormat decimalFormat = new DecimalFormat("##,##,##0");
        try {
            return decimalFormat.format(Integer.valueOf(number));
        }catch (Exception ex){
            return null;
        }
    }

    public static String convertToCustomPrice(String price,Integer decimalLen,Integer unitLen){
        if(price == null || price.isEmpty()) return null;
        try {
            String priceStr = "";
            DecimalFormat decimalFormat = new DecimalFormat("0.##");
            Double priceValue = Double.valueOf(price);
            Double tempPrice = Double.valueOf(decimalFormat.format(priceValue / 10000000));
            if (tempPrice >= 1) {
                if (unitLen != null && unitLen == 1)
                    priceStr = " Cr";
                else {
                    if (tempPrice == 1) {
                        priceStr = " Crore";
                    } else {
                        priceStr = " Crores";
                    }
                }
            } else {
                tempPrice = Double.valueOf(decimalFormat.format(priceValue / 100000));
                if (tempPrice >= 1) {
                    if (unitLen != null && unitLen == 1)
                        priceStr = " L";
                    else {
                        if (tempPrice == 1) {
                            priceStr = " Lac";
                        } else {
                            priceStr = " Lacs";
                        }
                    }
                } else
                    return formatNumberIndianStyle(price);
            }
            return tempPrice.toString() + priceStr;
        }catch (Exception ex){
            return null;
        }
    }
}
