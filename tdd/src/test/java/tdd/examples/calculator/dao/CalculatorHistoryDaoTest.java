package tdd.examples.calculator.dao;

import tdd.examples.calculator.config.DbConfig;
import tdd.examples.calculator.domain.CalculatorHistory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DbConfig.class)
@Transactional
public class CalculatorHistoryDaoTest {
    @Autowired
    private DataSource dataSource;
    private CalculatorHistoryDao dao;
    private CalculatorHistory input;

    @Before
    public void setUp() {
        dao = new CalculatorHistoryDao(dataSource);

        input = new CalculatorHistory();
        input.setValue1(5);
        input.setOperation("+");
        input.setValue2(10);
        input.setResult(15);
    }

    @Test
    public void shouldDelete() {
        // Given
        Long id = dao.insert(input);

        // When
        int affected = dao.deleteById(id);

        // Then
        assertThat(affected).isEqualTo(1);
    }

}