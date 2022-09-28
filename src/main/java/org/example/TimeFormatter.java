package org.example;

import org.example.exception.NegativeNumberException;

public class TimeFormatter {

    public String formatSecondsForReadableFormat(Long seconds) {
        Long number;
        boolean isTheFirstString = true;

        StringBuilder result = new StringBuilder();

        if (seconds < 0L) {
            throw new NegativeNumberException("The number should be positive!");
        }
        if (seconds == 0L) {
            return result.append("now").toString();
        }
        if ((seconds / 31536000L) >= 1) { //year
            number = Math.floorDiv(seconds, 31536000L);
            seconds -= (Math.floorDiv(seconds, 31536000L) * 31536000L);
            result = isTheFirstString ? result.append(number).append(" year") : result.append(", ").append(number).append(" year");
            isTheFirstString = false;
        }
        if ((seconds / 86400L) >= 1) { //day
            number = Math.floorDiv(seconds, 86400L);
            seconds -= (Math.floorDiv(seconds, 86400L) * 86400L);
            result = isTheFirstString ? result.append(number).append(" day") : result.append(", ").append(number).append(" day");
            isTheFirstString = false;
        }
        if ((seconds / 3600L) >= 1) { //hour
            number = Math.floorDiv(seconds, 3600L);
            seconds -= (Math.floorDiv(seconds, 3600L) * 3600L);

            result = isTheFirstString ? result.append(number).append(" hour") : result.append(", ").append(number).append(" hour");
            isTheFirstString = false;
        }
        if ((seconds / 60L) >= 1) { //minute
            number = Math.floorDiv(seconds, 60L);
            seconds -= (Math.floorDiv(seconds, 60L) * 60L);
            result = isTheFirstString ? result.append(number).append(" minute") : result.append(", ").append(number).append(" minute");
        }
        if ((seconds) >= 1 && seconds <= 60L) { //sec
            number = Math.floorDiv(seconds, 1L);
            result.append(" and ").append(number).append(" seconds");
        }
        return result.toString();
    }

}
