package com.zp;

public class Tests {
    public static void main(String[] args) {
        Long a=14L;
        System.out.println(a);
        int i = a.intValue();
        System.out.println(i);
        int i1 = i / 8;
        System.out.println(i1%8==0);
        if(i%8!=0){
            int i2 = i / 8;
            System.out.println("00000");
            System.out.println(i2);
            i2++;
            System.out.println(i2);
        }
        System.out.println(i1);
    }

}
