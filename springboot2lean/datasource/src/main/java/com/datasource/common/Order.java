package com.datasource.common;

import java.io.Serializable;

/**
 * @author HGH
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -7115392122646787268L;

    private String field;

    private int desc;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "field='" + field + '\'' +
                ", desc=" + desc +
                '}';
    }
}
