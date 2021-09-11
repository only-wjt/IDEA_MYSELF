package developmentErrors.annotation;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author onlyWjt
 * @date 2021年09月11日 1:05 下午
 * @desc
 */
public class Test03 {
    public static void main(String[] args) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
    }
}

/**
 * @author onlywjt
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface HardAnnotion{
    //这是注解的一个参数，参数形式就是 参数类型 参数名称()  defalut 默认值
//    所有基本类型（int,float,boolean,byte,double,char,long,short）
//    String
//    Class (如：Class<?> 或 Class<T>)
//    enum
//    Annotation
//上述类型的数组
    String value() default "";
    int i();
}
