package developmentErrors.Reflect;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.List;
import java.util.Map;

/**
 * @author onlyWjt
 * @date 2021年09月12日 2:32 下午
 * @desc
 */
public class ReflectTest {

    public void test01(Map<String,User> map, List<User> list){
        System.out.println("01");
    }
    public Map<String,User> test02(){
        System.out.println("02");
        return null;
    }

    public static void main(String[] args) throws Exception{
        //反射获取类
        Class<WjtPerson> wjtPersonClass = WjtPerson.class;
        Class<WjtStudent> WjtStudentClass = WjtStudent.class;
        Class<WjtTeacher> wjtTeacherClass = WjtTeacher.class;

        //通过反射获取方法
        Method eat = wjtPersonClass.getDeclaredMethod("eat", null);
        Method play = WjtStudentClass.getDeclaredMethod("play", String.class);
        Method teaching = wjtTeacherClass.getDeclaredMethod("teaching", String.class);
        System.out.println("=============通过反射调用方法=================");
        //通过反射调用方法
        eat.invoke(new WjtPerson(),null);
        play.invoke(new WjtStudent(), "篮球");
        teaching.invoke(new WjtTeacher(), "语文");
        System.out.println("=============通过反射获取参数=================");
        //通过反射获取参数
        Field[] declaredFields = WjtStudentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println("declaredFields=="+declaredFields);
        }
        System.out.println("=============通过反射获取方法类型=================");
        Class<?>[] parameterTypes = play.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            String name = parameterType.getName();
            System.out.println("方法类型：："+name);
        }
        System.out.println("=============通过反射获注解=================");
        Class<Food> foodClass = Food.class;
        Annotation[] annotations = foodClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("类注解：："+annotation);
        }
        Field price = foodClass.getDeclaredField("price");
        Annotation[] annotations1 = price.getAnnotations();
        WjtFiled annotation1 = price.getAnnotation(WjtFiled.class);
        System.out.println("获取注解的值：："+annotation1.length());
        for (Annotation annotation : annotations1) {
            System.out.println("参数注解：："+annotation);
        }
        System.out.println("================通过反射获取泛型=============");

        Method test01 = Test11.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = test01.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            //获取参数类型
            System.out.println(genericParameterType);
            if(genericParameterType instanceof ParameterizedType){//判断是不是结构化类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("真实：；"+actualTypeArgument);
                }
            }
        }
        System.out.println("----------------------------");
        Method test02 = Test11.class.getMethod("test02", null);
        Type genericReturnType = test02.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("返回值类型：："+actualTypeArgument);

            }
        }
    }
}
class WjtStudent extends WjtPerson{
    String grage;
    String sorce;
    @Override
    public void eat(){
        System.out.println("学生在学校吃饭");
    }
    public void play(String type){
        System.out.println("学生在玩"+type);
    }
}
class WjtTeacher extends WjtPerson{
    String job;
    String course;
    @Override
    public void eat(){
        System.out.println("老师在外吃饭");
    }
    public void teaching(String course){
        System.out.println("老师在教"+course);
    }
}
class WjtPerson{
    private String name;
    private int age;
    private int height;
    public void eat(){
        System.out.println("吃饭");
    }
}
@WjtRecord(name = "food", size = "100")
class Food{
    @WjtFiled(length = 10,name = "price",type = "double")
    double price;
    @WjtFiled(length = 100,name = "type",type = "varchar")
    double type;
}
/**
 * @author onlywjt
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface WjtRecord{
    String name();
    String size();
}
/**
 * @author onlywjt
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WjtFiled{
    int length();
    String name();
    String type();
}