package org.example.domain;

public enum YutGenerateOptions {

    RANDOM,
    DESIGNATED;

    public boolean isRandom() {
        return this == RANDOM;
    }
}
