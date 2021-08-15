package developmentErrors;

import org.apache.poi.hwpf.sprm.SprmIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author onlyWjt
 * @date 2021年08月14日 10:55 上午
 * @desc
 */
public class GranularitySync {

    private List<Integer> data = new ArrayList<>();

    //不涉及共享资源的慢方法
    private void slow() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    //错误的加锁方法
    public int wrong() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            //加锁粒度太粗了
            synchronized (this) {
                slow();
                data.add(i);
            }
        });
        System.out.println("耗费时间：："+(System.currentTimeMillis()-begin));
       // log.info("took:{}", System.currentTimeMillis() - begin);
        return data.size();
    }

    //正确的加锁方法
    public int right() {
        long begin = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1000).parallel().forEach(i -> {
            slow();
            //只对List加锁
            synchronized (data) {
                data.add(i);
            }
        });
        System.out.println("耗费时间：："+(System.currentTimeMillis()-begin));
        return data.size();
    }

    public static void main(String[] args) {
        GranularitySync granularitySync = new GranularitySync();
        granularitySync.wrong();
        granularitySync.right();
    }
}
