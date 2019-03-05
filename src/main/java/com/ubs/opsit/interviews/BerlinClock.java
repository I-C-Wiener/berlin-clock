package com.ubs.opsit.interviews;

import java.util.StringJoiner;

import static org.apache.commons.lang.StringUtils.repeat;

public class BerlinClock implements TimeConverter {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String YELLOW = "Y";
    private static final String RED = "R";
    private static final String OFF = "O";

    @Override
    public String convertTime(String aTime) {
        final Time time = Time.parse(aTime);

        return new StringJoiner(LINE_SEPARATOR)
                .add(seconds(time.getSeconds()))
                .add(topHours(time.getHours()))
                .add(bottomHours(time.getHours()))
                .add(topMinutes(time.getMinutes()))
                .add(bottomMinutes(time.getMinutes()))
                .toString();
    }

    private static String seconds(int seconds) {
        return seconds % 2 == 0 ? YELLOW : OFF;
    }

    private static String topHours(int hours) {
        return lightUp(hours / 5, 4, RED);
    }

    private static String bottomHours(int hours) {
        return lightUp(hours % 5, 4, RED);
    }

    private static String topMinutes(int minutes) {
        return distinguishQuarters(lightUp(minutes / 5, 11, YELLOW));
    }

    private static String bottomMinutes(int minutes) {
        return lightUp(minutes % 5, 4, YELLOW);
    }

    private static String lightUp(int litCount, int totalCount, String color) {
        return repeat(color, litCount) + repeat(OFF, totalCount - litCount);
    }

    private static String distinguishQuarters(String lamps) {
        return lamps.replaceAll(repeat(YELLOW, 3), repeat(YELLOW, 2) + RED);
    }
}
