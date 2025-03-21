package org.example.service;

import org.example.domain.YutGenerateOptions;
import org.example.domain.YutGenerator;
import org.example.domain.YutResult;

public class YutGameService {

    private final YutGenerator yutGenerator;

    public YutGameService(YutGenerator yutGenerator) {
        this.yutGenerator = yutGenerator;
    }

    public YutResult generateYut(YutGenerateOptions options, YutResult yutResult) {
        return yutGenerator.generate(options, yutResult);
    }
}
