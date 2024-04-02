package com.targetindia.tests;

import com.targetindia.utils.MathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class MathUtilsFactorialTests {

    @ParameterizedTest
    // @CsvSource({"2, 2", "3, 6", "5, 120", "6, 720", "7, 5040"})
    @CsvFileSource(files = {"/Users/vinod/Desktop/factorial-tests.csv"})
    // @MethodSource("sourceForShouldGetFactorialOfPositiveNumber")
    void shouldGetFactorialOfPositiveNumber(int input, long expected) {
        long actual = MathUtils.factorial(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldGetFactorialOfZero() {
        long expected = 1;
        long actual = MathUtils.factorial(0);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> sourceForShouldGetFactorialOfPositiveNumber(){
        return Stream.of(
                Arguments.of(5, 120),
                Arguments.of(8, 40320)
        );
    }
}
