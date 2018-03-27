package tdd.examples.calculator.service;


import tdd.examples.calculator.domain.CalculatorHistory;

import java.util.List;

public interface CalculatorHistoryService {
    List<CalculatorHistory> getCalculatorHistories();
    CalculatorHistory create(CalculatorHistory category);
    int delete(Long id);
}
