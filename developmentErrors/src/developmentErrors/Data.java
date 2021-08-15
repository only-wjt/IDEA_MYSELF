package developmentErrors;


import java.util.stream.IntStream;

/**
 * @author onlyWjt
 * @date 2021年08月14日 10:41 上午
 * @desc
 */
public class Data {
    private static int counter = 0;
    private static Object locker = new Object();

    public static int reset() {
        counter = 0;
        return counter;
    }

    public synchronized void wrong() {
        counter++;
    }

    public void right() {
        synchronized (locker) {//这个类的对象上锁，所以counter不会改变
            counter++;
        }
    }
    public static void main(String[] args) {
        Data.reset();
        IntStream.rangeClosed(1, 1000000).parallel().forEach(i->new Data().wrong());
        System.out.println(Data.counter);
    }
}
