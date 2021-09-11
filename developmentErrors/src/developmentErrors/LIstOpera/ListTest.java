package developmentErrors.LIstOpera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author onlyWjt
 * @date 2021年08月15日 10:47 上午
 * @desc
 */
public class ListTest {
    private static Logger logger = LoggerFactory.getLogger(ListTest.class);
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println("list:"+list+" size："+list.size()+" class"+list.get(0).getClass());

        int[] arr1 = {1, 2, 3};
        List list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println("list:"+list+" size："+list1.size()+" class"+list1.get(0).getClass());


        Integer[] arr2 = {1, 2, 3};
        List list2 = Arrays.asList(arr2);
        System.out.println("list:"+list+" size："+list2.size()+" class"+list2.get(0).getClass());
        System.out.println("==========");
        test();
        //oom();
        System.out.println("test2========");
        test2();
    }
    public static void test(){

        String[] arr = {"1", "2", "3"};
        //List list = Arrays.asList(arr);//此处放回的是Arrays里面的内部方法，没有实现add方法，所以不能做增删操作
        List list = new ArrayList(Arrays.asList(arr));
        arr[1] = "4";
        try {
            list.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("arr:"+Arrays.toString(arr)+" list："+list);
    }
    private static List<List<Integer>> data = new ArrayList<>();

    private static void oom() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 100000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
    }
    public static void test2(){
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        List<Integer> subList = list.subList(1, 4);
        System.out.println(subList);
        subList.remove(1);
        System.out.println(list);
        list.add(0);
        try {
            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //方式一：
        List<Integer> subList2 = new ArrayList<>(list.subList(1, 4));

        //方式二：
        List<Integer> subList3 = list.stream().skip(1).limit(3).collect(Collectors.toList());

    }
}
