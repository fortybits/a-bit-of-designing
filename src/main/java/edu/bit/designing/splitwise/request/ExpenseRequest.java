package edu.bit.designing.splitwise.request;

import java.util.List;

public record ExpenseRequest(String payingUser, int numberOfUsers, double totalAmount,
                             ExpenseType expenseType, List<String> users, List<Double> shareValues) {
}