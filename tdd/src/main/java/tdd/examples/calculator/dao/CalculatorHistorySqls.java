package tdd.examples.calculator.dao;

public class CalculatorHistorySqls {
	static final String SELECT_ALL =
			"SELECT id, value1, operation, value2, result FROM calculator_history\n"
			+ "ORDER BY id DESC";

	static final String DELETE_BY_ID =
			"DELETE FROM calculator_history WHERE id= :id";

}
