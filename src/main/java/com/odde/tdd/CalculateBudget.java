package com.odde.tdd;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class CalculateBudget{
    private List<Budget> budgets;

    public CalculateBudget(BudgetRepo budgetRepo) {
        this.budgets = budgetRepo.findAll();
    }


    public long calculate(LocalDate from, LocalDate to) {
        long total = 0;
        YearMonth fromMonth = YearMonth.from(from);
        YearMonth toMonth = YearMonth.from(to);
        int fromDate = from.getDayOfMonth();
        int toDate = to.getDayOfMonth();
        for (Budget budget : budgets) {
            YearMonth budget_month = budget.getYearMonth();
            long amount = budget.getAmount();
            if (budget_month.isBefore(fromMonth) || budget_month.isAfter(toMonth)) {
                continue;
            } else if (budget_month.equals(fromMonth)) {
                long dayAmount = amount / fromMonth.getMonth().maxLength();
                long monthAmount = dayAmount * (fromMonth.getMonth().maxLength() - fromDate + 1);
                total += monthAmount;
            } else if (budget_month.equals(toMonth)) {
                long dayAmount = amount / toMonth.getMonth().maxLength();
                long monthAmount = dayAmount * toDate;
                total += monthAmount;
            } else {
                total += amount;
            }
        }

        return total;

    }
}
