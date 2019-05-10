package com.odde.tdd;

import java.text.ParseException;
import java.util.Date;

public interface DateProvider {

    Date getDate() throws ParseException;
}
