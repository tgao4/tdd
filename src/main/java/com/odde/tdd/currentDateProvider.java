package com.odde.tdd;

import java.text.ParseException;
import java.util.Date;

public class currentDateProvider implements DateProvider {

    @Override
    public Date getDate() throws ParseException {
        return new Date();
    }
}
