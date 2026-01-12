package org.example;

public class Item {
    private int value;
    private int originalIndex;

    public Item(int value, int originalIndex) {
        this.value = value;
        this.originalIndex = originalIndex;
    }

    @Override
    public String toString() {
        return "Value, Index: " + value +", " + originalIndex;
    }

    public int getValue() {
        return value;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }
}
