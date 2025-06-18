package com.revature.fibonacci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    void testBaseCases() {
        assertEquals(0L, fibonacci.calculate(0));
        assertEquals(1L, fibonacci.calculate(1));
    }

    @Test
    void testRecursiveCases() {
        assertEquals(1L, fibonacci.calculate(2));
        assertEquals(2L, fibonacci.calculate(3));
        assertEquals(3L, fibonacci.calculate(4));
        assertEquals(5L, fibonacci.calculate(5));
        assertEquals(55L, fibonacci.calculate(10));
    }

    @Test
    void testLargeNumber() {
        assertEquals(6765L, fibonacci.calculate(20));
    }

    @Test
    void testPerformanceForLargeNumber() {
        assertTimeoutPreemptively(Duration.ofSeconds(4), () -> {
            assertEquals(12586269025L, fibonacci.calculate(50)); // Example for n = 30
        });
    }

}
