package com.bruyako;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;
import java.util.Locale;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import static org.junit.Assert.assertEquals;

/**
 * Created by brunyatko on 11.03.16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Calendar.class, MessageService.class})
public class TestMessageService {

    private static final String DEF_NIGHT = "Good night, World!";
    private static final String DEF_MORNING = "Good morning, World!";
    private static final String DEF_DAY = "Good day, World!";
    private static final String DEF_EVENING = "Good evening, World!";

    private static final String RU_NIGHT = "Доброй ночи, Мир!";
    private static final String RU_MORNING = "Доброе утро, Мир!";
    private static final String RU_DAY = "Добрый день, Мир!";
    private static final String RU_EVENING = "Добрый вечер, Мир!";

    private Calendar mockCalendar = Mockito.mock(Calendar.class);

    @Before
    public void setUp(){
        mockStatic(Calendar.class);
        when(Calendar.getInstance(new Locale("ru","UA"))).thenReturn(mockCalendar);
    }

    @Test
    public void testGetMessageDefaultNight() throws Exception {
        baseTest(new Locale("no", "NO"), 3, DEF_NIGHT);
    }

    @Test
    public void testGetMessageDefaultMorning() throws Exception {
        baseTest(new Locale("no", "NO"), 7, DEF_MORNING);
    }

    @Test
    public void testGetMessageDefaultDay() throws Exception {
        baseTest(new Locale("no", "NO"), 13, DEF_DAY);
    }

    @Test
    public void testGetMessageDefaultEvening() throws Exception {
        baseTest(new Locale("no", "NO"), 21, DEF_EVENING);
    }

    @Test
    public void testGetMessageRuNight() throws Exception {
        baseTest(new Locale("ru", "RU"), 2, RU_NIGHT);
    }

    @Test
    public void testGetMessageRuMorning() throws Exception {
        baseTest(new Locale("ru", "RU"), 8, RU_MORNING);
    }

    @Test
    public void testGetMessageRuDay() throws Exception {
        baseTest(new Locale("ru", "RU"), 12, RU_DAY);
    }

    @Test
    public void testGetMessageRuEvening() throws Exception {
        baseTest(new Locale("ru", "RU"), 20, RU_EVENING);
    }

    private void baseTest(Locale locale, int hours, String expectedMessage) throws Exception{
        Mockito.when(mockCalendar.get(Calendar.HOUR_OF_DAY)).thenReturn(hours);
        Locale.setDefault(locale);

        assertEquals(expectedMessage, new MessageService().getMessage());
    }
}
