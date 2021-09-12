package developmentErrors.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author onlyWjt
 * @date 2021年09月12日 11:27 上午
 * @desc 获得类的信息
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("developmentErrors.Reflect.User");
        System.out.println(c1.getName());//获取的全类名
        System.out.println(c1.getSimpleName());//获取包名
        c1 = User.class;
        System.out.println(c1.getSimpleName()); //只能找到public属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //获取指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println("name==="+name);

        //获得方法
        Method[] methods = c1.getMethods();//获得本类和父类public的方法
        Method[] declaredMethods = c1.getDeclaredMethods();//获取本类的方法

        //获取指定方法
        c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(setName);

        //获取构造器
        c1.getConstructors();
        c1.getDeclaredConstructors();

        //获取指定构造器
        c1.getDeclaredConstructor(String.class);
    }
}
