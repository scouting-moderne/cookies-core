package io.moderne.scouting.cookies;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public final class CookieCalculator {

    private CookieCalculator() {
    }

    public static BigDecimal calculatePrice(Map<CookieType, Integer> cookies, @Nullable BigDecimal discountPercentage) {
        BigDecimal price = BigDecimal.ZERO;
        for (Map.Entry<CookieType, Integer> entry : cookies.entrySet()) {
            price = price.add(calculatePrice(entry.getKey(), discountPercentage).multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return price;
    }

    public static BigDecimal calculatePrice(CookieType cookieType, @Nullable BigDecimal discountPercentage) {
        BigDecimal price = switch (cookieType) {
            case STROOPWAFEL -> BigDecimal.valueOf(0.50);
            case KANO -> BigDecimal.valueOf(1.00);
            case KOKOSMAKROON -> BigDecimal.valueOf(1.50);
            case EIERKOEK -> BigDecimal.valueOf(1.00);
            case GEVULDE_KOEK -> BigDecimal.valueOf(1.20);
            case ROZE_KOEK -> BigDecimal.valueOf(1.50);
        };
        if (discountPercentage != null) {
            BigDecimal multiplier = BigDecimal.ONE.subtract(discountPercentage.divide(BigDecimal.valueOf(100),2, RoundingMode.HALF_UP));
            price = price.multiply(multiplier);
        }
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}
