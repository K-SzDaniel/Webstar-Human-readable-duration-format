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
        Assertions.assertEquals("1 minute and 1 second", testCase2);
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
        Assertions.assertEquals("1 year, 1 day, 2 hours and 35 seconds", testCase6);
    }

    @Test
    void test_Case2() {
        String testCase7 = formatter.formatSecondsForReadableFormat(31629755L);
        Assertions.assertEquals("1 year, 1 day, 2 hours, 2 minutes and 35 seconds", testCase7);
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

    @Test
    void test_One_Year_And_One_Second() {
        String testCase9 = formatter.formatSecondsForReadableFormat(31536001L);
        Assertions.assertEquals("1 year and 1 second", testCase9);

    }

    @Test
    void test_Case3() {
        String testCase10 = formatter.formatSecondsForReadableFormat(63252275L);
        Assertions.assertEquals("2 years, 2 days, 2 hours, 4 minutes and 35 seconds", testCase10);
    }
    @Test
    void test_Case4() {
        String testCase11 = formatter.formatSecondsForReadableFormat(31626138L);
        Assertions.assertEquals("1 year, 1 day, 1 hour, 2 minutes and 18 seconds", testCase11);
    }

    @Test
    void test_Case5() {
        String testCase12 = formatter.formatSecondsForReadableFormat(31622400L);
        Assertions.assertEquals("1 year and 1 day", testCase12);
    }

}
