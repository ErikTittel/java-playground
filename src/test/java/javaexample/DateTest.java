package javaexample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
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
}
