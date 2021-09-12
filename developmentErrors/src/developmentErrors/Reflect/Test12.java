package developmentErrors.Reflect;

import net.sf.saxon.functions.Id;
import sun.tools.jconsole.Tab;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;

/**
 * @author onlyWjt
 * @date 2021年09月12日 2:12 下午
 * @desc 反射操作注解
 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("developmentErrors.Reflect.Student2");
        //通过反射获取注解
        AnnotatedType[] annotatedInterfaces = c1.getAnnotatedInterfaces();
        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
            System.out.println(annotatedInterface);
        }

        //获取注解的值
        TableStudent annotation = c1.getAnnotation(TableStudent.class);
        String value = annotation.value();
        System.out.println("value"+value);

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FiledStudent annotation1 = name.getAnnotation(FiledStudent.class);
        annotation1.columnName();
        annotation1.length();
        annotation1.type();
    }
}
@TableStudent(value = "db_student")
class Student2{
    @FiledStudent(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FiledStudent(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FiledStudent(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
/**
 * @author onlywjt
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableStudent{
    String value();
}

/**
 * @author onlywjt
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledStudent{
    String columnName();
    String type();
    int length();
}