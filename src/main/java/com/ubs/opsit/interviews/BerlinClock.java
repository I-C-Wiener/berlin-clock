package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
        if (!aTime.matches("^(?:\\d|[01]\\d|2[0-4]):[0-5]\\d:[0-5]\\d$")) {
            throw new IllegalArgumentException(String.format("The specified time '%s' does not conform to the required format, 'hh:mm:ss'.", aTime));
        }

        String[] timeParts = aTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        String lineSeparator = System.getProperty("line.separator");

        return new StringBuilder(9)
                .append(buildSecondsLamp(seconds)).append(lineSeparator)
                .append(buildFiveHoursLamps(hours)).append(lineSeparator)
                .append(buildOneHourLamps(hours)).append(lineSeparator)
                .append(buildFiveMinutesLamps(minutes)).append(lineSeparator)
                .append(buildOneMinuteLamps(minutes))
                .toString();
    }

    private static String buildSecondsLamp(int seconds) {
        return seconds % 2 == 0 ? "Y" : "O";
    }

    private static StringBuilder buildFiveHoursLamps(int hours) {
        return buildLamps(hours / 5, 4, "R");
    }

    private static StringBuilder buildOneHourLamps(int hours) {
        return buildLamps(hours % 5, 4, "R");
    }

    private static StringBuilder buildFiveMinutesLamps(int minutes) {
        return highlightQuarters(buildLamps(minutes / 5, 11, "Y"));
    }

    private static StringBuilder buildOneMinuteLamps(int minutes) {
        return buildLamps(minutes % 5, 4, "Y");
    }

    private static StringBuilder buildLamps(int highlightCondition, int count, String color) {
        StringBuilder result = new StringBuilder(count);

        for (int i = 0; i < count; i++) {
            result.append(highlightCondition > i ? color : "O");
        }

        return result;
    }

    private static StringBuilder highlightQuarters(StringBuilder lamps) {
        for (int i = 0; i < lamps.length(); i++) {
            if (lamps.charAt(i) == 'O') {
                break;
            } else if ((i + 1) % 3 == 0) {
                lamps.replace(i, i + 1, "R");
            }
        }

        return lamps;
    }
}
