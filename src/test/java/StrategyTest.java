import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import strategy.FixDiscountPolicy;
import strategy.RateDiscountPolicy;
import strategy.Shop;

public class StrategyTest {

    @Test
    void strategyTest() {
        FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy(1000);
        RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy(0.05);

        Shop shop = new Shop();
        int paymentAmount1 = shop.getPaymentAmount(10000, fixDiscountPolicy);
        Assertions.assertEquals(paymentAmount1, 9000);

        int paymentAmount2 = shop.getPaymentAmount(10000, rateDiscountPolicy);
        Assertions.assertEquals(paymentAmount2, 9500);
    }
}
