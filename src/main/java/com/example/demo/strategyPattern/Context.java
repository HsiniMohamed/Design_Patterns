package com.example.demo.strategyPattern;



public class Context {

	Strategy strategy=new DefaultStrategyImpl();

	public void effectuerOperation() {
		
		System.out.println("****************");
		strategy.operationStrategy();
		System.out.println("****************");

	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
}
