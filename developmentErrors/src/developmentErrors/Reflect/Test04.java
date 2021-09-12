package developmentErrors.Reflect;

import jodd.madvoc.meta.In;

import java.lang.annotation.ElementType;

/**
 * @author onlyWjt
 * @date 2021年09月12日 10:14 上午
 * @desc 所有类型的class
 */
public class Test04 {
    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;//类
        Class<Comparable> comparableClass = Comparable.class;//接口
        Class<String[]> aClass = String[].class;//数组
        Class<int[][]> aClass1 = int[][].class;//二维数组
        Class<Override> overrideClass = Override.class;//注解
        Class<ElementType> elementTypeClass = ElementType.class;//枚举
        Class<Integer> integerClass = Integer.class;//基本数据类型
        Class<Void> voidClass = void.class;//void类型
        Class<Class> classClass = Class.class;//class
        System.out.println(objectClass);
        System.out.println(comparableClass);
        System.out.println(aClass);
        System.out.println(aClass1);
        System.out.println(overrideClass);
        System.out.println(elementTypeClass);
        System.out.println(integerClass);
        System.out.println(voidClass);
        System.out.println(classClass);

        //只要元素类型与纬度一样，就是同一个class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
