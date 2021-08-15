package developmentErrors.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author onlyWjt
 * @date 2021年08月14日 12:48 下午
 * @desc
 */
public class Item {
    static final  String name = null; //商品名
    int remaining = 1000; //库存剩余 @ToString.Exclude //ToString不包含这个字段
    ReentrantLock lock = new ReentrantLock();
    public static String getName(Item item) {
        return Item.name;
    }
}
