1.@XmlRootElement，用于类级别的注解，对应xml的跟元素。通过name属性定义这个根节点的名称。
2.@XmlAccessorType，定义映射这个类中的何种类型都需要映射到xml。(如果不存在@XmlAccessorType,默认使用XmlAccessType.PUBLIC_MEMBER注解)
　　参数：XmlAccessType.FIELD: java对象中的所有成员变量。
　　XmlAccessType.PROPERTY：java对象中所有通过getter/setter方式访问的成员变量。
　　XmlAccessType.PUBLIC_MEMBER：java对象中所有的public访问权限的成员变量和通过getter/setter方式访问的成员变量。
　　XmlAccessType.NONE: java对象的所有属性都不映射为xml的元素。
3.@XmlAttribute，用于把java对象的属性映射为xml的属性,并可通过name属性为生成的xml属性指定别名。
4.@XmlElement，指定一个字段或get/set方法映射到xml的节点。通过name属性定义这个根节点的名称。
5.@XmlElementWrapper，为数组或集合定义一个父节点。通过name属性定义这个父节点的名称。
6.@XmlTransient
作用和用法：
类，字段，方法级别的注解。可使JAXB在映射xml元素时忽略被注解的类，字段，get/set对应字段。需要注意的是该注解与所有其他JAXB注释相互排斥，也就是说与其他注释连用就会报错
@XmlValue：
作用和用法：
字段和方法级别的注解。该注解的作用，简单理解就是定义xml元素文本值的类型，例如在一个类的String类型字段上使用该注解，则生成的元素文本值类型就是xsd:string，也就是定义一个xsd中的simpleType.若类中还有一个字段并使用了@XmlAttribute注解，则是定义一个xsd中的complexType。
```
   @XmlAccessorType(XmlAccessType.FIELD)
   public class NAME {
       @XmlAttribute()
       private String key="123";
       @XmlValue()
       private String value="abc";
    }
   ----------------------
    <NAME key="123">abc</NAME>

```