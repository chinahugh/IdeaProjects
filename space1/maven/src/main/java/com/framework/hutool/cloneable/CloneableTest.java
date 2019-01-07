package com.framework.hutool.cloneable;

import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;

/**
 * @author HUGH
 * @Date 2018/12/27 23:05
 * @Description CloneableTest
 */
public class CloneableTest implements Cloneable<CloneableTest> {
    @Override
    public CloneableTest clone() {
        try {
            CloneableTest clone = (CloneableTest)super.clone();
            return  clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
class A extends CloneSupport<A>{
    String a;
}
