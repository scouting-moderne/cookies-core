package io.moderne.scouting.cookies;

import java.math.BigDecimal;
import java.util.Map;

public final class CookieCalculator {

    private CookieCalculator() {
    }

    public static BigDecimal calculatePrice(Map<CookieType, Integer> cookies) {
        BigDecimal price = BigDecimal.ZERO;
        for (Map.Entry<CookieType, Integer> entry : cookies.entrySet()) {
            price = price.add(calculatePrice(entry.getKey()).multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return price;
    }

    public static BigDecimal calculatePrice(CookieType cookieType) {
        return switch (cookieType) {
            case STROOPWAFEL -> BigDecimal.valueOf(0.5);
            case KANO -> BigDecimal.valueOf(1);
            case KOKOSMAKROON -> BigDecimal.valueOf(1.5);
            case EIERKOEK -> BigDecimal.valueOf(1);
            case GEVULDE_KOEK -> BigDecimal.valueOf(1.2);
            case ROZE_KOEK -> BigDecimal.valueOf(1.5);
        };
    }
}
