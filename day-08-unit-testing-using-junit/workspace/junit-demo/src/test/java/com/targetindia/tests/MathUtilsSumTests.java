package com.targetindia.tests;

import com.targetindia.utils.MathUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsSumTests {



    @Test
    @DisplayName("should calculate the sum of 3 inputs")
    void shouldCalculateSumOfThreeInputs() {
        var expected = 30.0;
        var actual = MathUtils.sum("10", "2", "8", "4", "6");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should get an exception for less than 2 inputs")
    void shouldGetExceptionForLessThanTwoInputs() {
        try {
            MathUtils.sum("123");
            // if you are here, that means there is no exception
            // which means the test has failed
            fail("expected IllegalArgumentException, but didn't get one!");
        } catch (IllegalArgumentException e) {
            // the test has passed.
            // nothing to be done here!
        }
    }

    @Test
    @DisplayName("should get an exception for no input")
    void shouldGetExceptionForLessNoInput() {
        Executable function = () -> {
            MathUtils.sum();
        };
        assertThrows(IllegalArgumentException.class, function);
    }

}
