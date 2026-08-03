package advent_2022.AoC11;

import java.util.List;

public class Monkey {
    private int id;
    private List<Integer> items;
    private char operationType;
    private int operationValue;
    private int testValue;
    private int ifTrue;
    private int ifFalse;
    private int operations;

    public Monkey(int id, List<Integer> items, char operationType, int operationValue,
                  int testValue, int ifTrue, int ifFalse) {
        this.id = id;
        this.items = items;
        this.operationType = operationType;
        this.operationValue = operationValue;
        this.testValue = testValue;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.operations = 0;
    }

    public List<Integer> getItems() { return items; }
    public int getTestValue() { return testValue; }
    public int getIfTrue() { return ifTrue; }
    public int getIfFalse() { return ifFalse; }
    public int getOperations() { return operations; }
    public void setOperations(int operations) { this.operations = operations; }
    public char getOperationType() { return operationType; }
    public int getOperationValue() { return operationValue; }
}