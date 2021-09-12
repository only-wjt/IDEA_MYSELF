package developmentErrors.Reflect;

/**
 * @author onlyWjt
 * @date 2021年09月12日 10:53 上午
 * @desc 类什么时候会初始化
 */
public class Test06 {
    static {
        System.out.println("主类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
        //Son son = new Son();
        //Class.forName("developmentErrors.Reflect.Son");

        //不会产生类应用的的方法 （此时子类不会被加载）
        //System.out.println(Son.b);
        //Son[] sons = new Son[5];
        //常量不会初始化，是因为加载时已经赋值，并放到常量池中
        System.out.println(Son.i);
    }
}
class Father{
    static int b = 2;
    static {
        System.out.println("父类");
    }
}
class Son extends Father{
    static {
        System.out.println("子类");
        m=100;
    }
    static int m = 300;
    static final int i = 1;
}