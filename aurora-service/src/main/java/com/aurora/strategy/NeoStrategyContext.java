package com.aurora.strategy;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class NeoStrategyContext {
    @Resource
    private Map<String, StrategyInterface> strategyMap = new HashMap<>();

    public Long doMethod(String operate, int param1, int param2){
        StrategyInterface strategyInterface = strategyMap.get(operate);
        if(strategyInterface == null){
            throw new UnsupportedOperationException("未定义的操作");
        }
        return strategyInterface.strategyMethod(param1,param2);
    }
}
