package org.example.domain;

public enum YutResult {

    DO(1),
    GAE(2),
    GUL(3),
    YUT(4),
    MO(5),
    BACK_DO(-1),
    ;

    private final int step;

    YutResult(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }
}
