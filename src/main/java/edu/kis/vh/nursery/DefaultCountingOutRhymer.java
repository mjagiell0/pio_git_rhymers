package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int EMPTY = -1;
    private static final int MAX_SIZE = 12;
    private static final int DEFAULT_VALUE = -1;
    final private int[] numbers = new int[MAX_SIZE];

    private int total = EMPTY;

    protected void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    protected boolean callCheck() {
        return total == EMPTY;
    }

    protected boolean isFull() {
        return total == MAX_SIZE - 1;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_VALUE;
        return numbers[total];
    }

    protected int countOut() {
        if (callCheck())
            return DEFAULT_VALUE;
        return numbers[total--];
    }

}
