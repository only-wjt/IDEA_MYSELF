package developmentErrors.annotation;

import java.lang.annotation.*;

/**
 * @author onlyWjt
 * @date 2021年09月11日 12:42 下午
 * @desc
 */
public class Test02 {
    @TestAnnotion
    public void test(){
        System.out.println("test");
    }

}
/**
 * @author onlywjt
 */ //表示注解可以用在哪些地方
@Target(value = {ElementType.TYPE,ElementType.METHOD})
//表示注解在什么地方有效
@Documented
//子类可以继承父类的注解
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@interface TestAnnotion{

}