package developmentErrors.NumeralCalculations;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author onlyWjt
 * @date 2021年08月15日 9:20 上午
 * @desc
 */
public class FloatTest {
    public static void main(String[] args) {
//        double num1 = 3.35;
//        float num2 = 3.35f;
//        System.out.println(String.format("%.1f", num1));//四舍五入
//        System.out.println(String.format("%.1f", num2));

        BigDecimal num1 = new BigDecimal("3.35");
        BigDecimal num2 = num1.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(num2);
        BigDecimal num3 = num1.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(num3);
        System.out.println(new BigDecimal("1.0").equals(new BigDecimal("1")));
        System.out.println(new BigDecimal("1.0").compareTo(new BigDecimal("1"))==0);


        long l = Long.MAX_VALUE;
        System.out.println(l + 1);
        System.out.println(l + 1 == Long.MIN_VALUE); //-9223372036854775808

        try {
            long l1 = Long.MAX_VALUE;
            System.out.println(Math.addExact(l1, 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        BigInteger i = new BigInteger(String.valueOf(Long.MAX_VALUE));
        System.out.println(i.add(BigInteger.ONE).toString());

        try {
            long l2 = i.add(BigInteger.ONE).longValueExact();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
