package developmentErrors.Reflect;

/**
 * @author onlyWjt
 * @date 2021年09月12日 11:10 上午
 * @desc
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统加载器的父类加载器 -->扩展累加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展累的父类加载器 -->根加载器(C++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //测试当前类是哪个加载起加载的
        ClassLoader classLoader = Class.forName("developmentErrors.Reflect.Test07").getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader2 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader2);

        //获取系统类加载器加载的路径


        //双亲委派机制

    }
}
