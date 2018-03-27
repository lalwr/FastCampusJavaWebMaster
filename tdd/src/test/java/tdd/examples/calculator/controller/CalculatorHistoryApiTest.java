package tdd.examples.calculator.controller;

import tdd.examples.calculator.config.RootApplicationContextConfig;
import tdd.examples.calculator.config.ServletContextConfig;
import tdd.examples.calculator.domain.CalculatorHistory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ServletContextConfig.class, RootApplicationContextConfig.class})
@WebAppConfiguration
public class CalculatorHistoryApiTest {
	@Autowired
    WebApplicationContext wac;
	@Autowired
    CalculatorHistoryController calculatorHistoryController;

	MockMvc mvc;
	
	@Before
	public void setUp() {
		this.mvc = webAppContextSetup(this.wac)
			.alwaysDo(print(System.out))
			.build();
	}

	@Test
	public void test() throws Exception{

	}

	@Test
	public void shouldCreate() throws Exception {
		String requestBody = "{\"value1\":5, \"operation\":\"+\", \"value2\":10,\"result\":15}";

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
	}


	@Test
	public void shoulDelete() throws Exception {
		CalculatorHistory calculatorHistory = new CalculatorHistory(5, "+", 10, 15);
		CalculatorHistory calculatorHistoryResult = calculatorHistoryController.create(calculatorHistory);


		mvc.perform(
				delete("/calculatorHistories/{id}", calculatorHistoryResult.getId())
						.contentType(MediaType.APPLICATION_JSON)
		)
				.andExpect(status().isOk());
	}
}