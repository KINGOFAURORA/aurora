package com.aurora.strategy;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class StrategyFactory {
    @Resource
    private Map<String, StrategyInterface> strategyMap = new HashMap<>();

    public StrategyInterface getStrategy(String operate){
        StrategyInterface strategyInterface = strategyMap.get(operate);
        if(strategyInterface == null){
            throw new UnsupportedOperationException("未定义的操作");
        }
        return strategyInterface;
    }
}
