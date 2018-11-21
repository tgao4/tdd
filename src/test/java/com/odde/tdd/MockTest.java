package com.odde.tdd;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockTest {
    @Test
    public void mock_repo(){
        BudgetRepo repo = mock(BudgetRepo.class);
        when(repo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 11), 1000)));
        assertEquals(1, repo.findAll().size());
        verify(repo).findAll();
    }

    @Test
    public void mock_calculate() {
        BudgetRepo repo = mock(BudgetRepo.class);
        when(repo.findAll()).thenReturn(Arrays.asList(new Budget(YearMonth.of(2018, 7), 31),
                new Budget((YearMonth.of(2018, 8)), 310),
                new Budget(YearMonth.of(2018, 9), 3000),
                new Budget(YearMonth.of(2018, 10), 310)));
        CalculateBudget calculateBudget = new CalculateBudget(repo);
        Long result = calculateBudget.calculate(LocalDate.of(2018, Month.JULY, 15), LocalDate.of(2018, Month.OCTOBER, 10));
        assertEquals(17+310+3000+100, (int) ( result & 0xFFFFFFFF ));
    }


}
