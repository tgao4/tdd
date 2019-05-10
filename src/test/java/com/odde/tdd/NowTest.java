package com.odde.tdd;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class NowTest {
    @Test
    public void testNow() throws ParseException {
        Now now = new Now(new fixDateProvider());
        String result = now.getString();
        assertEquals("2014-11-20 11:00:01.111", result);
    }

    public class fixDateProvider implements DateProvider {
        @Override
        public Date getDate() throws ParseException {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
                    .parse("2014-11-20 11:00:01.111");
        }
    }
}
