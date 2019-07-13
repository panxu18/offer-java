package com.xup.offer.ch6;

public class StrToInt {
    public int strToInt(String str) {
        int ret = 0;
        try {
            ret = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            // 不处理
        }
        return ret;
    }
}
