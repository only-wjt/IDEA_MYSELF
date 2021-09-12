package developmentErrors.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author onlyWjt
 * @date 2021年09月12日 1:31 下午
 * @desc 通过反射动态创建对象
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c1 = Class.forName("developmentErrors.Reflect.User");

        //构造一个对象
        User user = (User)c1.newInstance(); //本质上调用无参构造器

        //通过构造器创建对象
        Constructor<?> declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User)declaredConstructor.newInstance("王际涛", 1, 2);
        System.out.println(user1);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance(); //本质上调用无参构造器
        //通过放射
        Method setName = c1.getDeclaredMethod("setName", String.class);
        Object 王际涛 = setName.invoke(user3, "王际涛");
        System.out.println(user3.getName());
        System.out.println("===============================");
        //通过放射操作属性
        User user4 = (User)c1.newInstance(); //本质上调用无参构造器

        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭安全检测，即打开访问权限
        name.setAccessible(true);//取消安全检测
        name.set(user4,"王际涛");
        System.out.println(user4.getName());
    }
}
