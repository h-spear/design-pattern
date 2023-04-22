package strategy;

public class Shop {

    public int getPaymentAmount(int price, DiscountPolicy policy) {
        return price - policy.getDiscountPrice(price);
    }
}
