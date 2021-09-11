package developmentErrors.Reflect;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author onlyWjt
 * @date 2021年08月25日 4:41 下午
 * @desc
 */

class Parent<T> {
    //用于记录value更新的次数，模拟日志记录的逻辑
    AtomicInteger updateCount = new AtomicInteger();
    private T value;
    //重写toString，输出值和值更新次数
    @Override
    public String toString() {
        return String.format("value: %s updateCount: %d", value, updateCount.get());
    }
    //设置值
    public void setValue(T value) {
        this.value = value;
        updateCount.incrementAndGet();
    }
}
