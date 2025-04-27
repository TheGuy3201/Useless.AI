package useless.ai;

public class MessageHelper {
    public static double incrementRate = 0;

    public static double getIncrementRate() {
        return incrementRate;
    }

    public static void setIncrementRate(double newRate) {
        incrementRate = newRate;
    }

    public static double incrementer(double prevHeight) {
        int padding = 10;
        incrementRate = incrementRate + prevHeight + padding;
        return incrementRate;
    }
}