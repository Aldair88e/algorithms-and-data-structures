package com.revature.subset_sum;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CanSumTargetTest {
    private SubsetSumI solver;
    // Suponiendo que esta es tu función a probar:
    @BeforeEach
    public void setUp(){
        solver = new SubsetSumWithMemoization();
    }

    @Test
    void testCasosBasicos() {
        assertTrue(solver.isSubsetSumPossible(Arrays.asList(2, 3, 5), 10)); // 5+5
        assertTrue(solver.isSubsetSumPossible(Arrays.asList(1, 2), 4));     // 2+2
        assertFalse(solver.isSubsetSumPossible(Arrays.asList(5, 10), 3));   // imposible
    }


    @Test
    void testUnSoloElemento() {
        assertTrue(solver.isSubsetSumPossible(Arrays.asList(3), 9));        // 3+3+3
        assertFalse(solver.isSubsetSumPossible(Arrays.asList(4), 10));      // no divisible
    }

    @Test
    void testGrandesConjuntos() {
        List<Integer> big = Arrays.asList(7, 13, 29);
        assertTrue(solver.isSubsetSumPossible(big, 58));                // 29+29
        assertFalse(solver.isSubsetSumPossible(big, 1));                // muy pequeño
    }

    @Test
    void testEficienciaConTiempo() {
        List<Integer> inputList = Arrays.asList(7, 14);
        assertTimeout(Duration.ofMillis(200), () -> {
            assertFalse(solver.isSubsetSumPossible(inputList, 300)); // 100_000 veces el 7
        });
    }

}