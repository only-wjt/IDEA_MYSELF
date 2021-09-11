package developmentErrors.Reflect;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author onlyWjt
 * @date 2021年08月25日 4:30 下午
 * @desc
 */
@Slf4j
public class ReflectionIssueApplication {
    private static Logger logger = LoggerFactory.getLogger(Reflect.class);
    void age(int age) {
        logger.error("int age = {}", age);
    }

    private void age(Integer age) {
        logger.error("Integer age = {}", age);
    }
}
