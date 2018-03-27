package tdd.examples.calculator.domain;

public class CalculatorHistory {
    private long id;
    private int value1;
    private String operation;
    private int value2;
    private int result;

    public CalculatorHistory(){
    }

    public CalculatorHistory(int value1, String operation, int value2) {
        this.value1 = value1;
        this.operation = operation;
        this.value2 = value2;
    }

    public CalculatorHistory(int value1, String operation, int value2, int result) {
        this.value1 = value1;
        this.operation = operation;
        this.value2 = value2;
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CalculatorHistory{" +
                "id=" + id +
                ", value1=" + value1 +
                ", operation='" + operation + '\'' +
                ", value2=" + value2 +
                ", result=" + result +
                '}';
    }
}

// lombok 을 사용할까요?