package developmentErrors.lamadatest.inner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author onlyWjt
 * @date 2021年09月12日 6:06 下午
 * @desc
 */
public class TestLambdaInner {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("使用匿名类的方式，筛选出 hp>100 && damange<50的英雄");
        HeroChecker heroChecker = new HeroChecker() {
            @Override
            public boolean test(Hero h, int hp, int damage) {
                return h.damage > hp && h.damage < damage;
            }
        };
        //filter(heros,heroChecker,100,50);

        filter(heros,(h,hp,damage)->h.damage>damage && h.hp<hp,100,50);

    }

    public static void filter(List<Hero> heros,HeroChecker checker,int hp,int damage){
        for (Hero hero : heros) {
            if(checker.test(hero,hp,damage)){
                System.out.println(hero);
            }
        }
    }

}
