package developmentErrors.sentence;

/**
 * @author onlyWjt
 * @date 2021年08月14日 9:29 下午
 * @desc
 */
enum StatusEnum {
        CREATED(1000, "已创建"),
        PAID(1001, "已支付"),
        DELIVERED(1002, "已送到"),
        FINISHED(1003, "已完成");

        private final Integer status; //注意这里的Integer
        private final String desc;

        StatusEnum(Integer status, String desc) {
            this.status = status;
            this.desc = desc;
        }
}
