package com.ubs.opsit.interviews;

import java.util.Objects;

class Time {
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    Time(Integer hours, Integer minutes, Integer seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    Integer getHours() {
        return hours;
    }

    Integer getMinutes() {
        return minutes;
    }

    Integer getSeconds() {
        return seconds;
    }

    static Time parse(String aTime) {
        validate(aTime);

        String[] timeParts = aTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        return new Time(hours, minutes, seconds);
    }

    private static void validate(String aTime) {
        if (!aTime.matches("^(?:\\d|[01]\\d|2[0-4]):[0-5]\\d:[0-5]\\d$")) {
            throw new IllegalArgumentException(String.format(
                    "The specified time '%s' does not conform to the required format, 'hh:mm:ss'.", aTime));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(hours, time.hours) &&
                Objects.equals(minutes, time.minutes) &&
                Objects.equals(seconds, time.seconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes, seconds);
    }
}
