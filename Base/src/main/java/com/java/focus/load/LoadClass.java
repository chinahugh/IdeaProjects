package com.java.focus.load;

public class LoadClass {
    public LoadClass(){
        System.out.println("无参构造");
    }
    public LoadClass(String args){
        this();
        System.out.println("有参构造");
    }
    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("代码块");
    }

    public static void main(String[] args) {
        LoadClass loadClass = new LoadClass();
        System.out.println("-------------------");
        LoadClass loadClass2 = new LoadClass("123");
    }
}
