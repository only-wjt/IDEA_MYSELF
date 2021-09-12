package developmentErrors.lamadatest;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import jdk.nashorn.internal.runtime.options.Option;
import org.apache.curator.shaded.com.google.common.base.Strings;
import org.apache.curator.shaded.com.google.common.collect.Lists;
import org.apache.hadoop.io.MapFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author onlyWjt
 * @date 2021年09月12日 4:25 下午
 * @desc
 */
public class Test01 {
    public static void main(String[] args) {
        test03();
        System.out.println("==================test04========");
        test04();
        System.out.println("==================test05========");
        test05();
        System.out.println("==================test06========");
        test06();
    }

    public void test01() {
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");
        List<String> lowercaseNames = new ArrayList<>();
        for (String name : names) {
            lowercaseNames.add(name.toLowerCase());
        }

    }

    public void test02() {
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");
        List<String> lowercaseNames = FluentIterable.from(names).transform(new Function<String, String>() {
            @Override
            public String apply(String name) {
                return name.toLowerCase();
            }
        }).toList();
    }

    public static void test03() {
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");
        List<String> lowercaseNames = names.stream().map(name ->
        {
            return name.toLowerCase();
        }).collect(Collectors.toList());
        System.out.println(lowercaseNames.toString());
        String[] array = {"a", "b", "c"};
        for(Integer i : Lists.newArrayList(1,2,3)){
            Stream.of(array).map(item -> Strings.padEnd(item, i, '@')).forEach(System.out::println);
        }
    }
    public static void test04(){
        List<String> names = new ArrayList<>();
        names.add("TaoBao");
        names.add("ZhiFuBao");
        List<String> collect = names.stream().map(name -> String.valueOf(name.charAt(0))).collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void test05(){
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println("nums中不为空的元素个数为：："+count);

    }
    public static void test06(){
        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("sum is:"+nums.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(System.out::println);

    }
}