package com.odde.tdd;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class Budget {
    private final YearMonth month;
    private final long amount;

    public Budget(YearMonth month, long amount) {
        this.month = month;
        this.amount = amount;
    }

    public YearMonth getYearMonth() {
        return month;
    }

    public long getAmount() {
        return amount;
    }

}
