package javaexample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {

    @Test
    public void parseLocalDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(("dd.MM.yyyy"));
        LocalDate date = LocalDate.parse("03.02.2016", df);

        assertThat(date.getDayOfMonth(), is(3));
        assertThat(date.getMonth(), is(Month.FEBRUARY));
        assertThat(date.getYear(), is(2016));
    }

    @Test
    public void formatLocalDateIsoUtc() {
        LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 13);
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();

        String text = instant.toString();

        assertThat(text, is("2016-02-12T23:00:00Z"));
    }

    @Test
    public void parseLocalDateIsoUtc() {
        String text = "2016-02-12T23:00:00Z";

        Instant instant = Instant.parse(text);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate date = zonedDateTime.toLocalDate();

        assertThat(date.getYear(), is(2016));
        assertThat(date.getMonth(), is(Month.FEBRUARY));
        assertThat(date.getDayOfMonth(), is(13));
    }
}
