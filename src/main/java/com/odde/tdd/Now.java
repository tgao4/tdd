package com.odde.tdd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Now {
    private final DateProvider dateProvider;

    public Now() {
        this(new currentDateProvider());
    }

    public Now(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    public String getString() throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
                .format(dateProvider.getDate());
    }

}
