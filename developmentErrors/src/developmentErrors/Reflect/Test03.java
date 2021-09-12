package developmentErrors.Reflect;

/**
 * @author onlyWjt
 * @date 2021年09月12日 10:05 上午
 * @desc 测试class类的创建方式
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式一
        Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        //方式二
        Class<?> aClass1 = Class.forName("developmentErrors.Reflect.Student");
        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());
        //方式三
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass.hashCode());


        Class<Integer> type = Integer.TYPE;

        //获取父类
        Class<?> superclass = aClass.getSuperclass();

    }
}
class Person{
    String name;

    public void person() {
    }

    public void person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}