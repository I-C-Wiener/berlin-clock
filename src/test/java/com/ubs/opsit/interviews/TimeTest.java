package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTest {

    @Test
    public void testParseMidnightWith0Hours() {
        Time expected = new Time(0,0, 0);
        Time actual = Time.parse("00:00:00");
        assertEquals(expected, actual);
    }

    @Test
    public void testParseMidnightWith24Hours() {
        Time expected = new Time(24,0, 0);
        Time actual = Time.parse("24:00:00");
        assertEquals(expected, actual);
    }

    @Test
    public void testParseArbitraryTime() {
        Time expected = new Time(1,23, 55);
        Time actual = Time.parse("01:23:55");
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidationFailureIfNonTimeStringProvided() {
        Time.parse("one:two");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidationFailureIfTimeConstituentMissed() {
        Time.parse("01:23");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidationFailureIfInvalidTimeStringProvided() {
        Time.parse("01:23:566");
    }

}
