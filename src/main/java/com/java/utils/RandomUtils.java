package com.java.utils;

import java.util.Random;

/**
 * @author HGH
 */
public class RandomUtils {
    public static void main(String[] args) {
        RandomUtils randomUtils = new RandomUtils();
//        randomUtils.t1();
//        Doclet doclet = new Doclet.	Doclet.Option();


    }

    public void t1() {
        Random random = new Random(1);
        double v = random.nextGaussian();
        System.out.println(v);

//        int max = 3, min = 0;
//        System.out.println(Math.random());
//        int ran2 = (int) (Math.random() * (max - min) + min);
//        System.out.println(ran2);


        int max = 100, min = 1;
        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum % (max - min) + min);
        System.out.println(ran3);
    }
}
