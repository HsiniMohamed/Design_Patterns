package com.example.demo.builderPattern.model;

public class Director {

public static BankAccount.AccountBuilder accountBuilder() {
		
		return new BankAccount.AccountBuilder();
	}
}
