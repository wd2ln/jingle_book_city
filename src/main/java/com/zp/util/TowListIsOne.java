package com.zp.util;

import java.util.Iterator;
import java.util.List;

public class TowListIsOne {
    public static Boolean isOne(List list1,List list2){
        if (list1.size()!=list2.size()){
            return false;
        }
        //list2要包含list1所有元素
        for (Iterator ita =list1.iterator();ita.hasNext(); ) {
            if (!list2.contains(ita.next())){
                return false;
            }
        }
        for (Iterator ita =list2.iterator();ita.hasNext(); ) {
            if (!list1.contains(ita.next())){
                return false;
            }
        }
        return true;
    }
}
