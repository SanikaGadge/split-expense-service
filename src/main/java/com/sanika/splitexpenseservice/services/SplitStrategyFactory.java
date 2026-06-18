package com.sanika.splitexpenseservice.services;

import org.springframework.stereotype.Service;

import com.sanika.splitexpenseservice.enums.SplitType;
import com.sanika.splitexpenseservice.strategy.EqualSplitStrategy;
import com.sanika.splitexpenseservice.strategy.SplitStrategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SplitStrategyFactory {

    private final EqualSplitStrategy equalSplitStrategy;

    public SplitStrategy getStrategy(SplitType type) {

        switch (type) {
            case EQUAL:
                return equalSplitStrategy;
            default:
                throw new RuntimeException("Unsupported split type");
        }
    }
}
