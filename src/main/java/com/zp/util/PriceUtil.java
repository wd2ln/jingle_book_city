package com.zp.util;

import java.math.BigDecimal;
    //价格逻辑util
public class PriceUtil {
    public static float add(float a,float b){
        BigDecimal bigA = new BigDecimal(Float.toString(a));
        BigDecimal bigB = new BigDecimal(Float.toString(b));
        return bigA.add(bigB).floatValue();
    }
    public static double add(double a,double b) {
        BigDecimal bigA = new BigDecimal(Double.toString(a));
        BigDecimal bigB = new BigDecimal(Double.toString(b));
        return bigA.add(bigB).doubleValue();
    }

    public static Float lenssen(Float a, Float b) {
        BigDecimal bigA = new BigDecimal(Float.toString(a));
        BigDecimal bigB = new BigDecimal(Float.toString(b));
        return bigA.subtract(bigB).floatValue();
    }
    }
