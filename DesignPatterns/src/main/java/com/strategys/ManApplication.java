package com.strategys;

import com.strategys.impl.CashbackStrategy;
import com.strategys.impl.CouponStrategy;
import com.strategys.impl.EmptyStraategy;
import com.strategys.impl.GroupbuyStrategy;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.Map;

public class ManApplication {

    private static Map<String,PromotionStrategy> PROMOTIONSTRATEGY_MAP = new HashMap<String, PromotionStrategy>();

    private static final PromotionStrategy NON_PROMOTIONSTRATEGY = new EmptyStraategy();
    static {
        PROMOTIONSTRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTIONSTRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTIONSTRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }

    public static void main(String[] args) {
//       new PromotionActivity(getPromotionStrategy("")).exec();
       System.out.println(PromotionKeyEnum.class.getEnumConstants()[0].getValue());
    }

    public static PromotionStrategy getPromotionStrategy(String PromotionKey){
        PromotionStrategy promotionStrategy = PROMOTIONSTRATEGY_MAP.get(PromotionKey);
        return promotionStrategy == null ? NON_PROMOTIONSTRATEGY : promotionStrategy;
    }

    public interface PromotionKey{
        String COUPON = "COUPON";

        String CASHBACK = "CASHBACK";

        String GROUPBUY = "GROUPBUY";
    }


    public enum PromotionKeyEnum{
        COUPON("COUPON","1"),
        CASHBACK("CASHBACK","2"),
        GROUPBUY("GROUPBUY","3");

        private String name;
        private String value;

        PromotionKeyEnum(String name,String value) {
            this.name = name;
            this.value = value;
        }

        public String getName(){
            return this.name;
        }
        public String getValue(){
            return this.value;
        }
    }
}
