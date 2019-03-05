package com.ubs.opsit.interviews;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Time {
    private static final Pattern TIME_PATTERN = Pattern.compile("^([0-2][0-4]):([0-5]\\d):([0-5]\\d)$");
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
        final Matcher matcher = TIME_PATTERN.matcher(aTime);

        if (matcher.matches()) {
            int hours = Integer.parseInt(matcher.group(1));
            int minutes = Integer.parseInt(matcher.group(2));
            int seconds = Integer.parseInt(matcher.group(3));
            return new Time(hours, minutes, seconds);
        } else {
            throw new IllegalArgumentException(String.format("Invalid date provided: '%s'", aTime));
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
