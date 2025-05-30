package org.core.domain.yut;

import java.util.Random;

public class RandomYutGenerateStrategy {

    private final int YUT_RESULT_COUNT = YutResult.values().length;

    public YutResult generate() {
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = random.nextInt(YUT_RESULT_COUNT);
        return YutResult.values()[randomIndex];
    }
}
