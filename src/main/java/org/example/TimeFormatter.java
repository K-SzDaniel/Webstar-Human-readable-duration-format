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

public class TimeFormatter {

    public static String formatSecondsForReadableFormat(Long seconds) {
        Long number = seconds % 86400L;
        StringBuilder result = new StringBuilder();

        if ((seconds / 86400L) >= 1) { //day
            number = Math.floorDiv(seconds, 86400L);
            seconds -= (Math.floorDiv(seconds, 86400L) * 86400L);
            result.append(" Day: ").append(number);
        }
        if ((seconds / 3600L) >= 1) { //hour
            number = Math.floorDiv(seconds, 3600L);
            seconds -= (Math.floorDiv(seconds, 3600L) * 3600L);
            result.append(" Hour: ").append(number);

        }
        if ((seconds / 60L) >= 1) { //hour
            number = Math.floorDiv(seconds, 60L);
            seconds -= (Math.floorDiv(seconds, 60L) * 60L);
            result.append(" Minutes: ").append(number);

        }
        if ((seconds) >= 1 && seconds <= 60L) { //hour
            number = Math.floorDiv(seconds, 1L);
            result.append(" Seconds: ").append(number);

        }


        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(formatSecondsForReadableFormat(864_0001L));
//        System.out.println(formatSecondsForReadableFormat(1000000000L));
    }

}
