package com.ubs.opsit.interviews;

import java.util.StringJoiner;

public class BerlinClock implements TimeConverter {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String YELLOW = "Y";
    private static final String RED = "R";
    private static final String OFF = "O";

    @Override
    public String convertTime(String aTime) {
        final Time time = Time.parse(aTime);

        return new StringJoiner(LINE_SEPARATOR)
                .add(buildSecondsLamp(time.getSeconds()))
                .add(buildFiveHoursLamps(time.getHours()))
                .add(buildOneHourLamps(time.getHours()))
                .add(buildFiveMinutesLamps(time.getMinutes()))
                .add(buildOneMinuteLamps(time.getMinutes()))
                .toString();
    }

    private static String buildSecondsLamp(int seconds) {
        return seconds % 2 == 0 ? YELLOW : OFF;
    }

    private static StringBuilder buildFiveHoursLamps(int hours) {
        return buildLamps(hours / 5, 4, RED);
    }

    private static StringBuilder buildOneHourLamps(int hours) {
        return buildLamps(hours % 5, 4, RED);
    }

    private static StringBuilder buildFiveMinutesLamps(int minutes) {
        return highlightQuarters(buildLamps(minutes / 5, 11, YELLOW));
    }

    private static StringBuilder buildOneMinuteLamps(int minutes) {
        return buildLamps(minutes % 5, 4, YELLOW);
    }

    private static StringBuilder buildLamps(int highlightCondition, int count, String color) {
        StringBuilder result = new StringBuilder(count);

        for (int i = 0; i < count; i++) {
            result.append(highlightCondition > i ? color : OFF);
        }

        return result;
    }

    private static StringBuilder highlightQuarters(StringBuilder lamps) {
        for (int i = 0; i < lamps.length(); i++) {
            if (lamps.charAt(i) == OFF.charAt(0)) {
                break;
            } else if ((i + 1) % 3 == 0) {
                lamps.replace(i, i + 1, RED);
            }
        }

        return lamps;
    }
}
