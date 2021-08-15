package developmentErrors.sentence;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author onlyWjt
 * @date 2021年08月14日 9:47 下午
 * @desc
 */

class Point {
    private int x;
    private int y;
    private final String desc;

    public Point(int x, int y, String desc) {
        this.x = x;
        this.y = y;
        this.desc = desc;
    }

    public static void main(String[] args) {
//        Point p1 = new Point(1, 2, "a");
//        Point p2 = new Point(1, 2, "b");
//        Point p3 = new Point(1, 2, "a");
//        System.out.println("p1.equals(p2)"+p1.equals(p2));
//        System.out.println("p1.equals(p3) "+p1.equals(p3));

        PointWrong p1 = new PointWrong(1, 2, "a");
        try {
            System.out.println("p1.equals(p3) "+p1.equals(null));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Object o = new Object();
        try {
            System.out.println("p1.equals(expression) "+p1.equals(o));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        PointWrong p2 = new PointWrong(1, 2, "b");
        System.out.println("p1.equals(p2) "+p1.equals(p2));


        PointWrong p3 = new PointWrong(1, 2, "a");
        PointWrong p4 = new PointWrong(1, 2, "b");

        HashSet<PointWrong> points = new HashSet<>();
        points.add(p3);
        System.out.println("points.contains(p2) "+ points.contains(p3));
    }

    static class PointWrong {
        private int x;
        private int y;
        private final String desc;

        public PointWrong(int x, int y, String desc) {
            this.x = x;
            this.y = y;
            this.desc = desc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointWrong that = (PointWrong) o;
            return x == that.x && y == that.y;
//            PointWrong that = (PointWrong) o;
//            return x == that.x && y == that.y;
        }
        @Override public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
