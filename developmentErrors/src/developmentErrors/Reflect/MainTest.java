package developmentErrors.Reflect;

import java.util.Arrays;

/**
 * @author onlyWjt
 * @date 2021年08月25日 4:44 下午
 * @desc
 */
public class MainTest {
    public static void main(String[] args) {
        Child1 child1 = new Child1();
        Arrays.stream(child1.getClass().getMethods())
                .filter(method -> method.getName().equals("setValue"))
                .forEach(method -> {
                    try {
                        method.invoke(child1, "test");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        System.out.println(child1.toString());
    }
}
