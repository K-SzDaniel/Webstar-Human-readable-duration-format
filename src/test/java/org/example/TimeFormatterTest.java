package org.example;

import org.example.exception.NegativeNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TimeFormatterTest {
    private TimeFormatter formatter;
    private final List<Long> timeTypeInSeconds = (List.of(31536000L, 86400L, 3600L, 60L, 1L, 0L));


    @BeforeEach
    void setUp() {
        this.formatter = new TimeFormatter();
    }

    @Test
    void test_One_Minute() {
        String testCase = formatter.formatSecondsForReadableFormat(60L);
        Assertions.assertEquals("1 minute", testCase);
    }

    @Test
    void test_One_Minute_And_One_Second() {
        String testCase = formatter.formatSecondsForReadableFormat(61L);
        Assertions.assertEquals("1 minute and 1 second", testCase);
    }

    @Test
    void test_One_Hour() {
        String testCase = formatter.formatSecondsForReadableFormat(3600L);
        Assertions.assertEquals("1 hour", testCase);
    }

    @Test
    void test_One_Day() {
        String testCase = formatter.formatSecondsForReadableFormat(86400L);
        Assertions.assertEquals("1 day", testCase);
    }

    @Test
    void test_One_Year() {
        String testCase = formatter.formatSecondsForReadableFormat(31536000L);
        Assertions.assertEquals("1 year", testCase);

    }

    @Test
    void test_Case1() {
        String testCase = formatter.formatSecondsForReadableFormat(31629635L);
        Assertions.assertEquals("1 year, 1 day, 2 hours and 35 seconds", testCase);
    }

    @Test
    void test_Case2() {
        String testCase = formatter.formatSecondsForReadableFormat(31629755L);
        Assertions.assertEquals("1 year, 1 day, 2 hours, 2 minutes and 35 seconds", testCase);
    }

    @Test
    void test_Zero_Second() {
        String testCase = formatter.formatSecondsForReadableFormat(0L);
        Assertions.assertEquals("now", testCase);

    }

    @Test
    void test_Negative_Second() {
        Assertions.assertThrows(NegativeNumberException.class, () -> formatter.formatSecondsForReadableFormat(-1L));
    }

    @Test
    void test_One_Year_And_One_Second() {
        String testCase = formatter.formatSecondsForReadableFormat(31536001L);
        Assertions.assertEquals("1 year and 1 second", testCase);

    }

    @Test
    void test_Case3() {
        String testCase = formatter.formatSecondsForReadableFormat(63252275L);
        Assertions.assertEquals("2 years, 2 days, 2 hours, 4 minutes and 35 seconds", testCase);
    }

    @Test
    void test_Case4() {
        String testCase = formatter.formatSecondsForReadableFormat(31626138L);
        Assertions.assertEquals("1 year, 1 day, 1 hour, 2 minutes and 18 seconds", testCase);
    }

    @Test
    void test_Case5() {
        String testCase = formatter.formatSecondsForReadableFormat(31622400L);
        Assertions.assertEquals("1 year and 1 day", testCase);
    }

    @Test
    void test_Case6() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(2);
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 1 hour", testCase);
    }

    @Test
    void test_Case7() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(2);
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 1 hour", testCase);
    }

    @Test
    void test_Case8() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(2) * 2;
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 2 hours", testCase);
    }

    @Test
    void test_Case9() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(3) * 2;
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 2 minutes", testCase);
    }

    @Test
    void test_Case10() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(3);
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 1 minute", testCase);
    }

    @Test
    void test_Case11() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(4);
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 1 second", testCase);
    }

    @Test
    void test_Case12() {
        Long seconds = timeTypeInSeconds.get(0) + timeTypeInSeconds.get(4) * 2;
        String testCase = formatter.formatSecondsForReadableFormat(seconds);
        Assertions.assertEquals("1 year and 2 seconds", testCase);
    }

}
