package com.tools.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Root")
//@XmlAccessorType(XmlAccessType.FIELD)
public class XmlBeanDemo {
//    @XmlElement
    private NAME Name = new NAME();
    //    @XmlElement(name = "NAME")
    private String Namee;

//    @XmlElementWrapper(name="NAME")
//@XmlElement(name = "NAME")
    private List<NAME> NAMES = new ArrayList<>();
    private String AGE;

    public NAME getName() {
        return Name;
    }

    public void setName(NAME name) {
        Name = name;
    }

    public String getNamee() {
        return Namee;
    }

    public void setNamee(String namee) {
        Namee = namee;
    }

    public List<NAME> getNAMES() {
        return NAMES;
    }

    public void setNAMES(List<NAME> NAMES) {
        this.NAMES = NAMES;
    }

    public String getAGE() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }
}
