package developmentErrors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author onlyWjt
 * @date 2021年08月12日 2:04 下午
 * @desc
 */
public class test {

    private static final ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);


    public Map wrong(Integer userId) {
        //设置用户信息之前先查询一次ThreadLocal中的用户信息
        String before  = Thread.currentThread().getName() + ":" + currentUser.get();
        //设置用户信息到ThreadLocal
        currentUser.set(userId);
        //设置用户信息之后再查询一次ThreadLocal中的用户信息
        try {
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            Map result = new HashMap();
            result.put("before", before);
            result.put("after", after);
            //汇总输出两次查询结果
            return result;
        } finally {
            //在finally代码块中删除ThreadLocal中的数据，确保数据不串
            currentUser.remove();
        }
    }

    public static void main(String[] args) {
        Map wrong = new test().wrong(1);
        System.out.println(wrong);
        Map wrong2 = new test().wrong(2);
        System.out.println(wrong2);
    }
}
