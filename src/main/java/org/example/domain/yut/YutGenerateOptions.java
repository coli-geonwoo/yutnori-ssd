package org.example.domain.yut;

public enum YutGenerateOptions {

    RANDOM,
    DESIGNATED;

    public boolean isRandom() {
        return this == RANDOM;
    }
}
