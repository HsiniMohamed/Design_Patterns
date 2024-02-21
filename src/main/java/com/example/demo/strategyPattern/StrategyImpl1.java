package com.example.demo.strategyPattern;

import com.example.demo.strategyPattern.Strategy;

public class StrategyImpl1 implements Strategy {

	@Override
	public void operationStrategy() {
		System.out.println("*******Strategy1********");
	}

}
