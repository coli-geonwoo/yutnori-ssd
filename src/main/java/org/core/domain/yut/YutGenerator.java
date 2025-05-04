package org.core.domain.yut;

public class YutGenerator {

    private final RandomYutGenerateStrategy randomYutGenerateStrategy;

    public YutGenerator(RandomYutGenerateStrategy randomYutGenerateStrategy) {
        this.randomYutGenerateStrategy = randomYutGenerateStrategy;
    }

    public YutResult generate(YutGenerateOptions options, YutResult designatedResult) {
        if (options.isRandom()) {
            return randomYutGenerateStrategy.generate();
        }
        return designatedResult;
    }
}
