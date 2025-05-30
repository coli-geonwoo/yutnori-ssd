package org.example.dto;

import org.example.domain.yut.YutGenerateOptions;
import org.example.domain.yut.YutResult;

public record YutGenerationRequest(YutGenerateOptions options, YutResult yutResult) {

}
