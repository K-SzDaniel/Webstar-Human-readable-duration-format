package org.example;



/*
-> Az eredményül kapott kifejezés olyan összetevőkből áll, mint 4 seconds, 1 year, stb.
 Általában egy pozitív egész szám és az érvényes időegységek egyike, szóközzel elválasztva.
 Az időegységet többes számban használjuk, ha az egész szám nagyobb, mint 1.

-> Az összetevőket vesszővel és szóközzel ( ", ") választjuk el. Kivéve az utolsó komponenst,
amely el van választva " and ", mint ahogy angolul írják.

-> Vegye figyelembe, hogy a szóközök fontosak.

-> Jelentősebb időegység fog bekövetkezni előtte, mint a legkevésbé jelentős. Ezért 1 second and 1 year nem helyes, de 1 year and 1 second igen.


->Egy komponens egyáltalán nem jelenik meg, ha értéke véletlenül nulla.
Ezért 1 minute and 0 seconds
nem érvényes, de igazságosnak kell lennie 1 minute.

->Egy időegységet „amennyire csak lehet” kell használni. Ez azt jelenti, hogy a függvénynek nem kell visszatérnie 61 seconds,
 hanem 1 minute and 1 secondhelyette. Formálisan egy komponens által megadott időtartam nem lehet hosszabb bármely érvényes, jelentősebb időegységnél.

*/

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
