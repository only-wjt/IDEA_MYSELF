package developmentErrors;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author onlyWjt
 * @date 2021年08月14日 10:11 上午
 * @desc
 */

public class Interesting {
    public Logger logger = LoggerFactory.getLogger(Interesting.class);
    volatile int a = 1;
    volatile int b = 1;

    public synchronized void add() {
        System.out.println("add start");
        //logger.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        System.out.println("add done");
        //logger.info("add done");
    }

    public synchronized void compare() {
        System.out.println("compare start");
        //logger.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                logger.info("a:{},b:{},{}", a, b, a > b);
                System.out.println("a:"+a+",b"+b+(a>b));
                //最后的a>b应该始终是false吗？
            }
        }
        System.out.println("compare done");
        //logger.info("compare done");
    }

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }
}
