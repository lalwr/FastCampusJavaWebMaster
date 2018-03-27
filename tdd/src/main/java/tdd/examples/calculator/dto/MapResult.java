package tdd.examples.calculator.dto;

import java.util.Map;


public class MapResult<T extends Map> {
    private T items;

    public MapResult(T items) {
        this.items = items;
    }

    public int getSize() {
        return items.size();
    }

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }
}
