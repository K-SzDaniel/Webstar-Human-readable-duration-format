package org.example;

import org.example.exception.NegativeNumberException;

import java.util.List;

public class TimeFormatter {

    public String formatSecondsForReadableFormat(Long seconds) {
        Long number;
        Long timeTypeInNumber;
        String timeTypeInString;
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
            timeTypeInNumber = timeTypeInSeconds.get(i);
            timeTypeInString = timeTypeTitle.get(i);

            if ((seconds / timeTypeInNumber) >= 1) { //year
                number = Math.floorDiv(seconds, timeTypeInNumber);
                seconds -= (Math.floorDiv(seconds, timeTypeInNumber) * timeTypeInNumber);

                if (isTheFirstString && !timeTypeInString.equals(" seconds")) {
                    result.append(number).append(" ").append(timeTypeInString);
                } else if (timeTypeInString.equals(" seconds")) {
                    result.append(" and ").append(number).append(timeTypeInString);
                } else {
                    result.append(", ").append(number).append(" ").append(timeTypeInString);
                }

                isTheFirstString = false;
            }
        }


        return result.toString();
    }

}
