package developmentErrors.sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author onlyWjt
 * @date 2021年08月14日 9:41 下午
 * @desc
 */
public class InternTest {

    List<String> list = new ArrayList<>();

    public int internperformance(int size) {
        //-XX:+PrintStringTableStatistics
        //-XX:StringTableSize=10000000
        long begin = System.currentTimeMillis();
        list = IntStream.rangeClosed(1, size)
                .mapToObj(i-> String.valueOf(i).intern())
                .collect(Collectors.toList());
        System.out.println("list长度"+size+"    耗时："+(System.currentTimeMillis() - begin));
        return list.size();
    }

    public static void main(String[] args) {
        new InternTest().internperformance(1000000);
    }
}
