package com.aurora.strategy.impl;

import com.aurora.strategy.StrategyInterface;
import org.springframework.stereotype.Component;

@Component("sub")
public class SubStrategy implements StrategyInterface {
    @Override
    public Long strategyMethod(int param1, int param2) {
        return (long) param1 - param2;
    }
}
