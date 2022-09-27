package org.example;

import org.example.exception.NegativeNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeFormatterTest {
    private TimeFormatter formatter;

    @BeforeEach
    void setUp() {
        this.formatter = new TimeFormatter();
    }

    @Test
    void test_One_Minute() {
        String testCase1 = formatter.formatSecondsForReadableFormat(60L);
        Assertions.assertEquals("1 minute", testCase1);
    }

    @Test
    void test_One_Minute_And_One_Second() {
        String testCase2 = formatter.formatSecondsForReadableFormat(61L);
        Assertions.assertEquals("1 minute and 1 seconds", testCase2);
    }

    @Test
    void test_One_Hour() {
        String testCase3 = formatter.formatSecondsForReadableFormat(3600L);
        Assertions.assertEquals("1 hour", testCase3);
    }

    @Test
    void test_One_Day() {
        String testCase4 = formatter.formatSecondsForReadableFormat(86400L);
        Assertions.assertEquals("1 day", testCase4);
    }

    @Test
    void test_One_Year() {
        String testCase5 = formatter.formatSecondsForReadableFormat(31536000L);
        Assertions.assertEquals("1 year", testCase5);

    }

    @Test
    void test_Case1() {
        String testCase6 = formatter.formatSecondsForReadableFormat(31629635L);
        Assertions.assertEquals("1 year, 1 day, 2 hour and 35 seconds", testCase6);
    }

    @Test
    void test_Case2() {
        String testCase7 = formatter.formatSecondsForReadableFormat(31629755L);
        Assertions.assertEquals("1 year, 1 day, 2 hour, 2 minute and 35 seconds", testCase7);
    }

    @Test
    void test_Zero_Second() {
        String testCase8 = formatter.formatSecondsForReadableFormat(0L);
        Assertions.assertEquals("now", testCase8);

    }

    @Test
    void test_Negative_Second() {
        Assertions.assertThrows(NegativeNumberException.class, () -> formatter.formatSecondsForReadableFormat(-1L));
    }
}
