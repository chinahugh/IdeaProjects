package com.java.core.system;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther HUGH
 * @Date 2018/6/21
 * @Description SystemArraycopy System类中arraycopy方法使用
 * 1.如果要拷贝的数组(原数组)是基本类型数组(int[]、 double[])时，使用System.arraycopy的目标数组是深拷贝
 * 2.如果要拷贝的数组(原数组)是单层引用类型（String[]、Integer[]、Object[]）时，使用System.arraycopy的
 * 目标数组是浅拷贝(拷贝后的数组的某一引用与原数组对应的引用相同，即(stringcopy[3] == strings[3]为真)
 * 但改变拷贝数组的元素内容时不会改变原数组内容(stringcopy[3]="sdf")，(因为数组存的是"sdf"
 * 在内存中的引用，当改变数组内容时，其实改变的是数组要存储的值的内存引用)
 * 3.如果要拷贝的数组(原数组)是自定义或多位数组引用类型（String[][]、User[]、int[][]）时，使用System.arraycopy的目标
 * 数组是浅拷贝，如果修改拷贝数组元素的属性的值，原数组也会改变，如果直接修改元素，即String[2]={"23","213"},
 * 时，原数组不变。
 * <p>
 * ***注：
 * 两个数组在内存中的地址是不一样的，使用System类中arraycopy方法拷贝后，他们存储了相同的引用地址，即存储相同元素，如果修改各自
 * 的引用，他们互不影响，如果修改数组某一元素的属性值，两者会同时改变.
 */
public class SystemArraycopy {
    @Test
    public void a() {
        //原数组
        int[] ints = new int[]{1, 2, 3, 4, 6};
        char[] chars = new char[]{'a', 'k', '8', '3', 'o', '胡'};
        String[] strings = new String[]{"a", "k", "8", "胡", "sasd"};
        Object[] objects = new Object[]{"dsa", 213, "sasd", new Object(), new User(1, "22", "asdadas")};
        //目标数组
        int[] intcopy = new int[10];
        char[] charcopy = new char[10];
        String[] stringcopy = new String[10];
        Object[] objectcopy = new Object[10];
        System.out.println("int数组拷贝打印");
        System.arraycopy(ints, 0, intcopy, 0, 5);
        System.out.println("ints[0]==intcopy[0] " + (ints[0] == intcopy[0]));
        //修改拷贝数组
        intcopy[3] = 100;
        System.out.println("ints = " + Arrays.toString(ints));
        System.out.println("incopy = " + Arrays.toString(intcopy));
        System.out.println("char数组拷贝打印");
        System.arraycopy(chars, 0, charcopy, 0, 5);
        //修改拷贝数组
        charcopy[3] = '1';
        System.out.println("chars = " + Arrays.toString(chars));
        System.out.println("charcopt = " + Arrays.toString(charcopy));
        System.out.println("字符串数组拷贝打印");
        System.arraycopy(strings, 0, stringcopy, 0, 5);
        System.out.println("stringcopy[0]==strings[0] = " + (stringcopy[3] == strings[3] ? "浅拷贝" : "深拷贝"));
        //修改拷贝数组
        stringcopy[3] = "qweqwe";
        System.out.println("stringcopy[0]==strings[0] = " + (stringcopy[3] == strings[3] ? "浅拷贝" : "深拷贝"));
        System.out.println("strings = " + Arrays.toString(strings));
        System.out.println("stringcopy = " + Arrays.toString(stringcopy));
        System.out.println("引用数组拷贝打印");
        System.arraycopy(objects, 0, objectcopy, 0, 5);
        System.out.println("objectcopy[4]==objects[4] =" + (objectcopy[4] == objects[4] ? "浅拷贝" : "深拷贝"));
        //修改拷贝数组
        ((User) objectcopy[4]).setEmail("三大框架发阿萨德飞机");
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("objectcopy = " + Arrays.toString(objectcopy));
        System.out.println("objects = " + objects[4]);
        System.out.println("objectcopy = " + objectcopy[4]);
    }

    @Test
    public void c() {
        //原数组
        int[][] ints = new int[][]{{1, 2, 3}, {4, 6}, {33, 6, 2}};
        char[] chars = new char[]{'a', 'k', '8', '3', 'o', '胡'};
        String[] strings = new String[]{"a", "k", "8", "胡", "sasd"};
        Object[] objects = new Object[]{"dsa", 213, "sasd", new Object(), new User(1, "22", "asdadas")};
        //目标数组
        int[][] intcopy = new int[10][];
        char[] charcopy = new char[10];
        String[] stringcopy = new String[10];
        Object[] objectcopy = new Object[10];
        System.out.println("int数组拷贝打印");
        System.arraycopy(ints, 0, intcopy, 0, 3);
        System.out.println("ints[0]==intcopy[0] " + (ints[0] == intcopy[0]));
        //修改拷贝数组
        intcopy[1][1] = 100;
        for (int[] anInt : ints) {
            System.out.println("ints = " + Arrays.toString(anInt));
        }
        for (int[] anIntcopy : intcopy) {
            System.out.println("intcopy = " + Arrays.toString(anIntcopy));
        }
    }

    @Test
    public void b() {
        //初始化对象数组
        User[] users = new User[]{new User(1, "admin", "admin@qq.com"), new User(2, "maco", "maco@qq,com"), new User(3, "kitty", "kitty@qq,com")};
        //新建一个目标对象数组
        User[] target = new User[10];
        //实现复制
        System.arraycopy(users, 0, target, 0, users.length);
        System.out.println("源对象与目标对象的物理地址是否一样：" + (users[0] == target[0]));
        target[0].setEmail("admin@sina.com");
        System.out.println("修改目标对象的属性值后源对象users：");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("Arrays.toString(users) = " + Arrays.toString(users));
        System.out.println("Arrays.toString(target) = " + Arrays.toString(target));
    }
}

class User {
    private Integer id;
    private String username;
    private String email;

    //无参构造函数
    public User() {
    }

    //有参的构造函数
    public User(Integer id, String username, String email) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email
                + "]";
    }
}
