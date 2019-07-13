package com.xup.offer.ch6;

public class AddWithoutMathOprate {
    public int add(int num1, int num2) {
        //不进位加
        int b = (num1 ^ num2);
        // 进位
        int a = (num1 & num2) << 1;
        while (a != 0) {
            int temp = b;
            b = a ^ b;
            a = (a & temp) << 1;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new AddWithoutMathOprate().add(111,899));
    }
}
