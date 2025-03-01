public class TicketPrice
{
    public static final double FAST_PASS_PRICE = 1.05; // 5% increase for fast riders
    public static final double NORMAL_PRICE = 1.00; // standard price multiplier

    public static double getPriceMultiplier(boolean isFastPass)
    {
        return isFastPass ? FAST_PASS_PRICE : NORMAL_PRICE;
    }
}