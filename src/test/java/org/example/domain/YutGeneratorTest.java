package org.example.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class YutGeneratorTest {

    @DisplayName("지정된 윷 던지기 : 지정된 윷 결과를 반환한다")
    @ParameterizedTest
    @EnumSource(value = YutResult.class)
    void generate(YutResult yutResult) {
        YutGenerator yutGenerator = new YutGenerator(new RandomYutGenerateStrategy());

        YutResult result = yutGenerator.generate(YutGenerateOptions.DESIGNATED, yutResult);

        assertThat(result).isEqualTo(yutResult);
    }
}
