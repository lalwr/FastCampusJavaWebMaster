package tdd.examples.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdd.examples.calculator.domain.CalculatorHistory;
import tdd.examples.calculator.dto.CollectionResult;
import tdd.examples.calculator.service.CalculatorHistoryService;

import java.util.List;

/**
 * Created by urstory on 2017. 4. 24.
 */
@RestController
public class CalculatorHistoryController {
    @Autowired
    CalculatorHistoryService calculatorHistoryService;

    @GetMapping(path="/calculatorHistories")
    public CollectionResult<List<CalculatorHistory>> list(){

        return new CollectionResult<>(calculatorHistoryService.getCalculatorHistories());

    }

    @PostMapping(path="/calculatorHistories")
    public CalculatorHistory create(@RequestBody CalculatorHistory calculatorHistory){
        int result = 0;
        if("+".equals(calculatorHistory.getOperation())){
            result = calculatorHistory.getValue1() + calculatorHistory.getValue2();
        }else if("-".equals(calculatorHistory.getOperation())){
            result = calculatorHistory.getValue1() - calculatorHistory.getValue2();
        }else if("*".equals(calculatorHistory.getOperation())){
            result = calculatorHistory.getValue1() * calculatorHistory.getValue2();
        }else if("/".equals(calculatorHistory.getOperation())){
            if(calculatorHistory.getValue2() == 0)
                throw new IllegalArgumentException("0으로 나눌수 없습니다.");
            result = calculatorHistory.getValue1() / calculatorHistory.getValue2();
        }else{
            throw new IllegalArgumentException("지원하지 않는 operation입니다.");
        }
        calculatorHistory.setResult(result);
        CalculatorHistory calculatorHistoryResult = calculatorHistoryService.create(calculatorHistory);
        return calculatorHistoryResult;

    }

    @DeleteMapping(path="/calculatorHistories/{id}")
    public int delete(@PathVariable(name = "id")Long id) {
        int deleteCount = calculatorHistoryService.delete(id);
        return deleteCount;
    }
}
