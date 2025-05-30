package org.core.dto;

import org.core.domain.yut.YutGenerateOptions;
import org.core.domain.yut.YutResult;

public record YutGenerationRequest(YutGenerateOptions options, YutResult yutResult) {

}
