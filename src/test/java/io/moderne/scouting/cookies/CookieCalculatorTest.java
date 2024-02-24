package io.moderne.scouting.cookies;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CookieCalculatorTest {

    @Test
    void calculatePrice() {
        Map<CookieType, Integer> cookies = Map.of(
                CookieType.STROOPWAFEL, 1,
                CookieType.EIERKOEK, 2
        );
        BigDecimal price = CookieCalculator.calculatePrice(cookies, null);
        assertEquals(BigDecimal.valueOf(2.5), price);
    }

    @Test
    void calculatePriceWithDiscount() {
        Map<CookieType, Integer> cookies = Map.of(
                CookieType.STROOPWAFEL, 1,
                CookieType.EIERKOEK, 2
        );
        BigDecimal price = CookieCalculator.calculatePrice(cookies, BigDecimal.valueOf(10));
        assertEquals(BigDecimal.valueOf(2.25), price);
    }
}