package developmentErrors.threadPool;

import com.actionsoft.bpms.util.UUIDGener;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author onlyWjt
 * @date 2021年08月14日 2:21 下午
 * @desc
 */
public class ThreadTest1 {

    public void oom1() throws InterruptedException {
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        //打印线程池的信息，稍后我会解释这段代码
        printStats(threadPool);
        for (int i = 0; i < 100000000; i++) {
            threadPool.execute(() -> {
                String payload = IntStream.rangeClosed(1, 1000000)
                        .mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUIDGener.getUUID().toString();
                try {
                    TimeUnit.HOURS.sleep(1);
                } catch (InterruptedException e) {
                }
                System.out.println("payload:"+payload);
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }
    public static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println("=========================");
            System.out.println("Pool Size: {}"+threadPool.getPoolSize());
            System.out.println("Active Threads: {}"+threadPool.getActiveCount());
            System.out.println("Number of Tasks Completed: {}"+threadPool.getCompletedTaskCount());
            //log.info("Pool Size: {}", threadPool.getPoolSize());
            //log.info("Active Threads: {}", threadPool.getActiveCount());
            //log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            System.out.println("Number of Tasks in Queue: {}"+threadPool.getQueue().size());
           // log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            //log.info("=========================");
            System.out.println("=====================");
        }, 0, 1, TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
        try {
            new ThreadTest1().oom1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
