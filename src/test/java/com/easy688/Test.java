package com.easy688;

public class Test {
    public static void main(String[] args) {

    }
    public int getNum(int num1,int num2){
        if(num1%num2==0){
            return num1;
        }
        if(num2%num1==0){
            return num2;
        }

        return 0;
    }
}
