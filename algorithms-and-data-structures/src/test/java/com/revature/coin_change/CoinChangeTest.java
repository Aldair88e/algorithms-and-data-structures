package com.revature.coin_change;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class CoinChangeTest {
    public CoinChangeI cc;
    @BeforeEach
    public void setUp(){
        cc = new CoinChangeMemoized();
    }
    @Test
    void testExactMatchSingleCoin() {
        assertEquals(1, cc.minCoins(new int[]{5}, 5));
    }

    @Test
    void testMultipleCoinsSimpleCase() {
        assertEquals(2, cc.minCoins(new int[]{1, 2, 5}, 6)); // 5 + 1
    }

    @Test
    void testUnreachableAmount() {
        assertEquals(-1, cc.minCoins(new int[]{2}, 3)); // imposible
    }

    @Test
    void testZeroAmount() {
        assertEquals(0, cc.minCoins(new int[]{1, 2, 5}, 0));
    }

    @Test
    void testLargeAmountWithSmallCoins() {
        assertEquals(4, cc.minCoins(new int[]{1, 2, 5}, 20)); // e.g. four 5s
    }

    @Test
    void testSingleCoinImpossible() {
        assertEquals(-1, cc.minCoins(new int[]{7}, 6));
    }

    @Test
    void testOnlyOneWay() {
        assertEquals(2, cc.minCoins(new int[]{2, 3}, 4)); // 2 + 2
    }

    @Test
    void testRedundantLargeCoins() {
        assertEquals(2, cc.minCoins(new int[]{1, 3, 4}, 6)); // 3+3 or 4+1+1
    }

    @Test
    void testTimeoutForInefficientRecursiveCall() {
        // Caso que crece exponencialmente: muchas formas lentas de construir 40 con monedas pequeñas
        int[] coins = {1, 2, 3};

        assertTimeoutPreemptively(Duration.ofMillis(300), () -> {
            cc.minCoins(coins, 40); // Esto puede explotar por recursividad ineficiente
        });
    }


}
