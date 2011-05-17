package net.azib.java.students.t107678.homework;

import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;


public class ParticipantTest {

    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    java.util.Date date, date1;

    {
        try {
            date = format.parse("16.06.1988");
            date1 = format.parse("15.06.1988");

        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    Participant participant = new Participant("Radomir Sebek", date, new CountryCode("me"));

    @Test
    public void testGetName() throws Exception {

        assertEquals("Radomir Sebek", participant.getName());

    }

    @Test
    public void testGetBirthDate() throws Exception {

        assertSame(date, participant.getBirthDate());

    }

    @Test
    public void testIncorrectGetBirthDate() throws Exception {

        assertNotSame(date1, participant.getBirthDate());
    }

    @Test
    public void testGetCountry() throws Exception {

        CountryCode countryCode = new CountryCode("ME");
        assertEquals(countryCode, participant.getCountry());

    }
}
