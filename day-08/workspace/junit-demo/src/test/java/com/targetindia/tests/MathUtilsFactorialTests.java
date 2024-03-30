package com.targetindia.tests;

import com.targetindia.utils.MathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathUtilsFactorialTests {

    @Test
    void shouldGetFactorialOfPositiveNumber(){
        long expected = 120;
        long actual = MathUtils.factorial(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldGetFactorialOfZero(){
        long expected = 1;
        long actual = MathUtils.factorial(0);
        Assertions.assertEquals(expected, actual);
    }

}
