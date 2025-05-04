package org.core.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.core.domain.yut.RandomYutGenerateStrategy;
import org.core.domain.yut.YutResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomYutGenerateStrategyTest {

    @DisplayName("랜덤한 윷 결과를 만든다")
    @Test
    void generate() {
        RandomYutGenerateStrategy randomYutGenerateStrategy = new RandomYutGenerateStrategy();

        assertThat(randomYutGenerateStrategy.generate())
                .isInstanceOf(YutResult.class);
    }
}