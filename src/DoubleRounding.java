import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleRounding {

    public static double roundingDoubleToHundredths(double doubleNumber) {
        BigDecimal result = new BigDecimal(doubleNumber);
        result = result.setScale(2, RoundingMode.HALF_UP);
        doubleNumber = result.doubleValue();
        return doubleNumber;
    }
}
