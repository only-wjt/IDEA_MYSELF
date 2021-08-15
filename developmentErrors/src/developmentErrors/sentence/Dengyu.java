package developmentErrors.sentence;

/**
 * @author onlyWjt
 * @date 2021年08月14日 9:23 下午
 * @desc
 */
public class Dengyu {
    public void main(String[] args) {
        Integer a = 127; //Integer.valueOf(127)
        Integer b = 127; //Integer.valueOf(127)
        System.out.println(a == b);

        Integer c = 128; //Integer.valueOf(128)
        Integer d = 128; //Integer.valueOf(128)
        System.out.println(c == d);

        Integer e = 127; //Integer.valueOf(127)
        Integer f = new Integer(127); //new instance
        System.out.println(e == f);

        Integer g = new Integer(127); //new instance
        Integer h = new Integer(127); //new instance
        System.out.println(g == h);

        Integer i = 128; //unbox
        int j = 128;
        System.out.println(i == j);
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.status = 100;
        new Dengyu().enumcompare(orderQuery);

    }
    public class OrderQuery {
        private Integer status;
        private String name;
    }
    public void enumcompare(OrderQuery orderQuery){
        StatusEnum statusEnum = StatusEnum.DELIVERED;
        System.out.println("=========="+StatusEnum.DELIVERED);
    }
}
