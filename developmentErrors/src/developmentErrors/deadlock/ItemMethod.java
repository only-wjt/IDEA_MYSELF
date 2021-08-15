package developmentErrors.deadlock;

import io.netty.util.internal.ThreadLocalRandom;
import org.hyperic.sigar.cmd.MemWatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author onlyWjt
 * @date 2021年08月14日 12:57 下午
 * @desc
 */
public class ItemMethod {
    private List<Item> createCart() {
        List<Item> items = new ArrayList<>();
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> "item" + ThreadLocalRandom.current().nextInt(items.size()))
                .map(name -> items.get(1)).collect(Collectors.toList());
    }

    private boolean createOrder(List<Item> order) {
        //存放所有获得的锁
        List<ReentrantLock> locks = new ArrayList<>();

        for (Item item : order) {
            try {
                //获得锁10秒超时
                if (item.lock.tryLock(10, TimeUnit.SECONDS)) {
                    locks.add(item.lock);
                } else {
                    locks.forEach(ReentrantLock::unlock);
                    return false;
                }
            } catch (InterruptedException e) {
            }
        }
        //锁全部拿到之后执行扣减库存业务逻辑
        try {
            order.forEach(item -> item.remaining--);
        } finally {
            locks.forEach(ReentrantLock::unlock);
        }
        return true;
    }

    public long wrong() {
        long begin = System.currentTimeMillis();
        //并发进行100次下单操作，统计成功次数
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart();
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();

//        log.info("success:{} totalRemaining:{} took:{}ms items:{}",
//                success,
//                items.entrySet().stream().map(item -> item.getValue().remaining).reduce(0, Integer::sum),
//                System.currentTimeMillis() - begin, items);
        return success;
    }
    //为购物车中的商品排一下序，让所有的线程一定是先获取 item1 的锁然后获取 item2 的锁
    //这样避免了一个线程去另外一个线程商品导致的死锁
    //虽然产生了死锁问题，但因为尝试获取锁的操作并不是无限阻塞的，所以没有造成永久死锁，之后的改进就是避免循环等待，通过对购物车的商品进行排序来实现有顺序的加锁，避免循环等待
    public long right() {
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = createCart().stream()
                            .sorted(Comparator.comparing(Item::getName))
                            .collect(Collectors.toList());
                    return createOrder(cart);
                })
                .filter(result -> result)
                .count();
        return success;
    }
}
