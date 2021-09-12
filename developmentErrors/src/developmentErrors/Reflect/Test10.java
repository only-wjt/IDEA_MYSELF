package developmentErrors.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author onlyWjt
 * @date 2021年09月12日  1:43 下午
 * @desc 分析反射性能问题
 */
public class Test10 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        //普通方式的调用
        Test10 test10 = new Test10();
        test10.test01();
        test10.test02();
        test10.test03();
    }
    public void test01(){
        User user = new User();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000000L; i++) {
            user.getName();
        }
        long endtime = System.currentTimeMillis();
        System.out.println("正常调用"+(endtime-time));
    }
    public void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<User> userClass = User.class;
        Method getName = userClass.getDeclaredMethod("getName",null);
        long time = System.currentTimeMillis();

        for (int i = 0; i < 100000000L; i++) {
          getName.invoke(user,null);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("反射调用"+(endtime-time));
    }
    public void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<User> userClass = User.class;
        Method getName = userClass.getDeclaredMethod("getName",null);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000000L; i++) {
            getName.setAccessible(true);
            getName.invoke(user,null);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("反射无检测调用"+(endtime-time));
    }
}
