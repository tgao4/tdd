package com.odde.tdd;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class NowTest {
    @Test
    public void testNow(){
        Now now = new Now();
        String result = now.getString();
        assertEquals(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
                .format(new Date()), result);
    }
}
