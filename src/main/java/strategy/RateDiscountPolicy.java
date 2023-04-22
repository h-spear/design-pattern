package strategy;

public class RateDiscountPolicy implements DiscountPolicy {

    private double discountRate;

    public RateDiscountPolicy(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int getDiscountPrice(int price) {
        return (int) (price * discountRate);
    }
}
