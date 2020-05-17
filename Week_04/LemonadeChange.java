package com.qunar.qboss.qer.common.lianxi.week04;

public class LemonadeChange {
    public  boolean lemonadeChange(int[] bills){
        if (bills == null) return false;
        if(bills[0] !=5 )return false;

        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }else if (bill == 10) {
                if (five < 1) {
                    return false;
                }
                five--;
                ten++;
            }else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }else if (five > 3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
