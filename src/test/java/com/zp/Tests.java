package com.zp;

import com.zp.util.TowListIsOne;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        /*Long a=14L;
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
        System.out.println(i1);*/
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("fj");
        a.add("kk");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("fj");
        b.add("kk1");
        Boolean one = TowListIsOne.isOne(a, b);
        System.out.println(one);
    }

}
