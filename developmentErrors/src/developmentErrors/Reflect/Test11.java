package developmentErrors.Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author onlyWjt
 * @date 2021年09月12日 1:58 下午
 * @desc 通过反射获取泛型
 */
public class Test11 {

    public void test01(Map<String,User> map, List<User> list){
        System.out.println("01");
    }
    public Map<String,User> test02(){
        System.out.println("02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
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
