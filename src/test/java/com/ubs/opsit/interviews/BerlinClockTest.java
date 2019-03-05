package com.ubs.opsit.interviews;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {
    private BerlinClock berlinClock = new BerlinClock();

    @Test
    public void testEvenSeconds() {
        String actual = berlinClock.convertTime("00:00:02");
        String expected = "Y\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
        assertEquals(expected, actual);
    }

    @Test
    public void testOddSeconds() {
        String actual = berlinClock.convertTime("00:00:01");
        String expected = "O\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO";
        assertEquals(expected, actual);
    }

    @Test
    public void testEvenMinutes() {
        String actual = berlinClock.convertTime("00:50:00");
        String expected = "Y\nOOOO\nOOOO\nYYRYYRYYRYO\nOOOO";
        assertEquals(expected, actual);
    }

    @Test
    public void testOddMinutes() {
        String actual = berlinClock.convertTime("00:51:00");
        String expected = "Y\nOOOO\nOOOO\nYYRYYRYYRYO\nYOOO";
        assertEquals(expected, actual);
    }

    @Test
    public void testEvenHours() {
        String actual = berlinClock.convertTime("12:00:00");
        String expected = "Y\nRROO\nRROO\nOOOOOOOOOOO\nOOOO";
        assertEquals(expected, actual);
    }

    @Test
    public void testOddHours() {
        String actual = berlinClock.convertTime("11:00:00");
        String expected = "Y\nRROO\nROOO\nOOOOOOOOOOO\nOOOO";
        assertEquals(expected, actual);
    }

}
