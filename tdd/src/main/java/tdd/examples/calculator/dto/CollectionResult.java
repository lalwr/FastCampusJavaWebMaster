package tdd.examples.calculator.dto;

import java.util.Collection;


public class CollectionResult<T extends Collection> {
    private T items;

    public CollectionResult(T items) {
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
