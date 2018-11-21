package com.odde.tdd;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class CalculateBudget{
    private List<Budget> allBudget;

//    public List<Budget> findAll() {
//        allBudget.add(new Budget(YearMonth.of(2018,7), 31));
//        allBudget.add(new Budget(YearMonth.of(2018,8), 310));
//        allBudget.add(new Budget(YearMonth.of(2018,9), 3000));
//        allBudget.add(new Budget(YearMonth.of(2018,10), 310));
//        return allBudget;
//    }

    public CalculateBudget(BudgetRepo budgetRepo) {
        this.allBudget = budgetRepo.findAll();
    }


    public long calculate(LocalDate from, LocalDate to) {
        long total = 0;
        YearMonth fromMonth = YearMonth.from(from);
        YearMonth toMonth = YearMonth.from(to);
        int fromDate = from.getDayOfMonth();
        int toDate = to.getDayOfMonth();
        for (Budget budget : allBudget) {
            YearMonth month = budget.getYearMonth();
            long amount = budget.getAmount();
            if (month.isBefore(fromMonth) || month.isAfter(toMonth)) {
                continue;
            }
            if ((month.isAfter(fromMonth) && month.isBefore(toMonth)) || month.equals(fromMonth) || month.equals(toMonth)) {
                total += amount;
            }
            if (month.equals(fromMonth) && (fromDate < fromMonth.getMonth().maxLength())) {
                total -= (amount / fromMonth.getMonth().maxLength()) * (fromDate - 1);
            }
            if (month.equals(toMonth) && (toDate < toMonth.lengthOfMonth())) {
                total -= (amount / toMonth.getMonth().maxLength()) * (toMonth.getMonth().maxLength() - toDate);
            }
        }

        return total;

    }
}
