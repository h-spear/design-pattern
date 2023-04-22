package strategy;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountPrice;

    public FixDiscountPolicy(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public int getDiscountPrice(int price) {
        return Math.min(price, discountPrice);
    }
}
