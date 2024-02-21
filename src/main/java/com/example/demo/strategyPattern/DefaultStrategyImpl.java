package com.example.demo.strategyPattern;

import com.example.demo.strategyPattern.Strategy;

public class DefaultStrategyImpl implements Strategy {

	@Override
	public void operationStrategy() {
		System.out.println("...........Default Strategy .........");
	}

}
