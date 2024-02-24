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
        BigDecimal price = CookieCalculator.calculatePrice(cookies);
        assertEquals(BigDecimal.valueOf(2.5), price);
    }
}