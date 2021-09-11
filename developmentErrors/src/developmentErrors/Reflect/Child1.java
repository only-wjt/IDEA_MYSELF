package developmentErrors.Reflect;

/**
 * @author onlyWjt
 * @date 2021年08月25日 4:43 下午
 * @desc
 */
class Child1 extends Parent {
    public void setValue(String value) {
        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
