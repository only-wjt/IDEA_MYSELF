package developmentErrors.Reflect;

import net.sf.saxon.functions.Id;

/**
 * @author onlyWjt
 * @date 2021年09月12日 9:37 上午
 * @desc
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("developmentErrors.Reflect.User");
        Class<?> aClass1 = Class.forName("developmentErrors.Reflect.User");
        Class<?> aClass2 = Class.forName("developmentErrors.Reflect.User");
        Class<?> aClass3 = Class.forName("developmentErrors.Reflect.User");
        System.out.println(aClass.hashCode());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

    }
}
class User{
    private String name;
    private int Id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        Id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", Id=" + Id +
                ", age=" + age +
                '}';
    }
}
