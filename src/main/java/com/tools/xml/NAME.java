package com.tools.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class NAME {
    @XmlAttribute()
    private String key;
    @XmlValue()
    private String lll;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLll() {
        return lll;
    }

    public void setLll(String lll) {
        this.lll = lll;
    }

    @Override
    public String toString() {
        return "NAME{" +
                "key='" + key + '\'' +
                ", lll='" + lll + '\'' +
                '}';
    }
}
