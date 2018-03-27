package tdd.examples.calculator.controller;

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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;
import tdd.examples.calculator.config.RootApplicationContextConfig;
import tdd.examples.calculator.config.ServletContextConfig;
import tdd.examples.calculator.domain.CalculatorHistory;
import tdd.examples.calculator.service.CalculatorHistoryService;
import tdd.examples.test.IntegrationTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletContextConfig.class, RootApplicationContextConfig.class})
@WebAppConfiguration
public class CalculatorHistoryApiTest2 {
	@Mock
	CalculatorHistoryService calculatorHistoryService;

	@InjectMocks
    CalculatorHistoryController calculatorHistoryController = new CalculatorHistoryController();

	MockMvc mvc;

	private static long id = 1L;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(calculatorHistoryController)
				.build();

		when(calculatorHistoryService.create(any(CalculatorHistory.class))).thenAnswer(
				new Answer<CalculatorHistory>() {
					public CalculatorHistory answer(InvocationOnMock invocation) {
						Object[] args = invocation.getArguments(); // arguments
						CalculatorHistoryService mock = (CalculatorHistoryService)invocation.getMock(); // mock itself
						CalculatorHistory arg = (CalculatorHistory)args[0];
						arg.setId(id++);
						return arg;
					}
				}
		);

		when(calculatorHistoryService.delete(anyLong())).thenAnswer(
				new Answer<Integer>() {
					public Integer answer(InvocationOnMock invocation) {
						Object[] args = invocation.getArguments(); // arguments
						CalculatorHistoryService mock = (CalculatorHistoryService)invocation.getMock(); // mock itself
						return 1;
					}
				}
		);

	}

	@Test
	public void test() throws Exception{

	}


	@Test(expected = NestedServletException.class)
	public void test_0으로_나눌때_오류발생() throws Exception {
		String requestBody = "{\"value1\":5, \"operation\":\"/\", \"value2\":0}";

		mvc.perform(
				post("/calculatorHistories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody)
		)
				.andExpect(status().isInternalServerError());
		verify(calculatorHistoryService).create(any(CalculatorHistory.class));
	}


	@Test
	public void shouldCreate() throws Exception {
		String requestBody = "{\"value1\":5, \"operation\":\"+\", \"value2\":10}";

		mvc.perform(
				post("/calculatorHistories")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody)
		)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.value1").value(5))
				.andExpect(jsonPath("$.operation").value("+"))
				.andExpect(jsonPath("$.value2").value(10))
				.andExpect(jsonPath("$.result").value(15));

		verify(calculatorHistoryService).create(any(CalculatorHistory.class));
	}


	@Test
	public void shoulDelete() throws Exception {
		CalculatorHistory calculatorHistory = new CalculatorHistory(5, "+", 10);
		CalculatorHistory calculatorHistoryResult = calculatorHistoryController.create(calculatorHistory);


		mvc.perform(
				delete("/calculatorHistories/{id}", calculatorHistoryResult.getId())
						.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk());
		verify(calculatorHistoryService).delete(anyLong());
		verify(calculatorHistoryService).delete(eq(calculatorHistoryResult.getId()));
	}
}