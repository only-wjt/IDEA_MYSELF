package developmentErrors.Reflect;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author onlyWjt
 * @date 2021年08月25日 4:20 下午
 * @desc
 */
public class Reflect {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectionIssueApplication application = new ReflectionIssueApplication();
//        application.age(36);
//        application.age(Integer.valueOf("36"));
        application.getClass().getDeclaredMethod("age", Integer.TYPE).invoke(ReflectionIssueApplication.class,Integer.valueOf("36"));
    }
}