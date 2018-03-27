package tdd.examples.calculator.service.impl;

import tdd.examples.calculator.service.CalculatorHistoryService;
import tdd.examples.calculator.dao.CalculatorHistoryDao;
import tdd.examples.calculator.domain.CalculatorHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorHistoryServiceImpl implements CalculatorHistoryService {

    @Autowired
    private CalculatorHistoryDao categoryDao;

    @Override
    public List<CalculatorHistory> getCalculatorHistories() {
        return categoryDao.selectAll();
    }

    @Override
    public CalculatorHistory create(CalculatorHistory category) {
        Long pk = categoryDao.insert(category);
        category.setId(pk);
        return category;
    }

    @Override
    public int delete(Long id) {
        return categoryDao.deleteById(id);
    }
}
