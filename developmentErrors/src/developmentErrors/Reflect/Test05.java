package developmentErrors.Reflect;

/**
 * @author onlyWjt
 * @date 2021年09月12日 10:25 上午
 * @desc
 */
public class Test05 {
    public Test05() {
        System.out.println("test05初始化");
    }

    public static void main(String[] args) {
        /**
         * 1、加载到内存，会产生一个类对应的class对象
         * 2、链接、链接结束后 吗= 0
         * 3、clinit(){
         *     m = 100;
         *     m = 300;
         * }
         */
        A a = new A();
        System.out.println(A.anInt);
    }
}
class A{
    static int anInt = 100;
    static{
        System.out.println("A类静态代码块初始化");
        anInt = 300;
    }

    public A() {
        System.out.println("A类型无参构造方法初始化");
    }
}