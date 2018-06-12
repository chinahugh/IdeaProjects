package com.java.focus.jvm.classload;

/**
 * @Auther HUGH
 * @Date 2018/6/12
 * @Description Hello 类加载
 */
public class Hello {
    public static void main(String[] args) {
        staticFunction();
    }

    static Hello book = new Hello();

    static {
        System.out.println("书的静态代码块");
    }

    {
        System.out.println("书的普通代码块");
    }

    Hello() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void staticFunction() {
        System.out.println("书的静态方法");
    }

    int price = 110;
    static int amount = 112;
}
/**
在上面例子中，因为 main 方法所在类并没有多余的代码，我们都直接忽略了 main 方法所在类的初始化。
但在这个例子中，main 方法所在类有许多代码，我们就并不能直接忽略了。
当 JVM 在准备阶段的时候，便会为类变量分配内存和进行初始化。此时，我们的 book 实例变量被初始化
为 null，amount 变量被初始化为 0。
当进入初始化阶段后，因为 Book 方法是程序的入口，根据我们上面说到的类初始化的五种情况的第四种：
当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主
类。JVM 会对 Book 类进行初始化。
JVM 对 Book 类进行初始化首先是执行类构造器（按顺序收集类中所有静态代码块和类变量赋值语句就组成
了类构造器），后执行对象的构造器（先收集成员变量赋值，后收集普通代码块，最后收集对象构造器，
最终组成对象构造器）。对于 Book 类，其类构造方法可以简单表示如下：

static Book book = new Book();
static
{
    System.out.println("书的静态代码块");
}
static int amount = 112;
于是首先执行static Book book = new Book();这一条语句，这条语句又触发了类的实例化。与类构造
器不同，于是 JVM 执行 Book 类的成员变量，再搜集普通代码块，最后执行类的构造方法，于是其执行
语句可以表示如下：

int price = 110;
{
    System.out.println("书的普通代码块");
}
Book()
{
    System.out.println("书的构造方法");
    System.out.println("price=" + price +", amount=" + amount);
}
于是此时 price 赋予 110 的值，输出：「书的普通代码块」、「书的构造方法」。而此时 price 为
 110 的值，而 amount 的赋值语句并未执行，所以只有在准备阶段赋予的零值，所以之后输出
 「price=110,amount=0」。

当类实例化完成之后，JVM 继续进行类构造器的初始化：

static Book book = new Book();  //完成类实例化
static
{
    System.out.println("书的静态代码块");
}
static int amount = 112;
即输出：「书的静态代码块」，之后对 amount 赋予 112 的值。

到这里，类的初始化已经完成，JVM 执行 main 方法的内容。
public static void main(String[] args)
{
    staticFunction();
}
即输出：「书的静态方法」。
 */