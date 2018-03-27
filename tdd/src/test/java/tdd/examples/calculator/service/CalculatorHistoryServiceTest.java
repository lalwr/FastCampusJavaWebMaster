package tdd.examples.calculator.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tdd.examples.calculator.config.RootApplicationContextConfig;
import tdd.examples.calculator.config.ServletContextConfig;
import tdd.examples.calculator.controller.CalculatorHistoryController;
import tdd.examples.calculator.dao.CalculatorHistoryDao;
import tdd.examples.calculator.domain.CalculatorHistory;
import tdd.examples.calculator.service.impl.CalculatorHistoryServiceImpl;
import tdd.examples.test.IntegrationTest;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootApplicationContextConfig.class})
public class CalculatorHistoryServiceTest {
	@InjectMocks
	CalculatorHistoryService calculatorHistoryService = new CalculatorHistoryServiceImpl();

	@Mock
	CalculatorHistoryDao calculatorHistoryDao;

	MockMvc mvc;

	private static long id = 1L;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		when(calculatorHistoryDao.insert(any(CalculatorHistory.class))).thenAnswer(
				new Answer<Long>() {
					public Long answer(InvocationOnMock invocation) {
						Object[] args = invocation.getArguments(); // arguments
						CalculatorHistoryDao mock = (CalculatorHistoryDao)invocation.getMock(); // mock itself
						return id++;
					}
				}
		);

		when(calculatorHistoryDao.deleteById(anyLong())).thenAnswer(
				new Answer<Integer>() {
					public Integer answer(InvocationOnMock invocation) {
						Object[] args = invocation.getArguments(); // arguments
						CalculatorHistoryDao mock = (CalculatorHistoryDao)invocation.getMock(); // mock itself
						return 1;
					}
				}
		);

	}

	@Test
	public void test() throws Exception{

	}

	@Test
	public void shouldCreate() throws Exception {
		CalculatorHistory calculatorHistory = new CalculatorHistory(5, "+", 10, 15);
		CalculatorHistory calculatorHistoryResult = calculatorHistoryService.create(calculatorHistory);

		verify(calculatorHistoryDao).insert(any(CalculatorHistory.class));

	}


	@Test
	public void shoulDelete() throws Exception {
		CalculatorHistory calculatorHistory = new CalculatorHistory(5, "+", 10, 15);
		CalculatorHistory calculatorHistoryResult = calculatorHistoryService.create(calculatorHistory);


		calculatorHistoryService.delete(calculatorHistoryResult.getId());

		verify(calculatorHistoryDao).deleteById(anyLong());
		verify(calculatorHistoryDao).deleteById(eq(calculatorHistoryResult.getId()));
	}
}