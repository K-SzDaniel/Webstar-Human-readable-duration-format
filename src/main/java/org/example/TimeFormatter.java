package org.example;

import org.example.exception.NegativeNumberException;

import java.util.List;

public class TimeFormatter {

    public String formatSecondsForReadableFormat(Long seconds) {
        Long number;
        Long test;
        String test2;
        boolean isTheFirstString = true;

        List<Long> timeTypeInSeconds = (List.of(31536000L, 86400L, 3600L, 60L, 1L));
        List<String> timeTypeTitle = (List.of("year", "day", "hour", "minute", " seconds"));

        StringBuilder result = new StringBuilder();

        if (seconds < 0L) {
            throw new NegativeNumberException("The number should be positive!");
        }
        if (seconds == 0L) {
            return result.append("now").toString();
        }

        for (int i = 0; i < 5; i++) {
            test = timeTypeInSeconds.get(i);
            test2 = timeTypeTitle.get(i);

            if ((seconds / test) >= 1) { //year
                number = Math.floorDiv(seconds, test);
                seconds -= (Math.floorDiv(seconds, test) * test);

                if (isTheFirstString && !test2.equals(" seconds")) {
                    result.append(number).append(" ").append(test2);
                } else if (test2.equals(" seconds")) {
                    result.append(" and ").append(number).append(test2);
                } else {
                    result.append(", ").append(number).append(" ").append(test2);
                }

                isTheFirstString = false;
            }
        }


        return result.toString();
    }

}
