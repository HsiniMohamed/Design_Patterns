package com.example.demo.builderPattern;

import java.util.List;
import java.util.Optional;

import com.example.demo.builderPattern.model.AccountStatus;
import com.example.demo.builderPattern.model.AccountType;
import com.example.demo.builderPattern.model.BankAccount;
import com.example.demo.builderPattern.model.repository.AccountRepository;
import com.example.demo.builderPattern.model.repository.AccountRepositoryImpl;
import com.example.demo.util.JsonSerializer;

public class BuilderTest {

	public static void main(String[] args) {
		JsonSerializer< BankAccount> bankAccountJsonSerializer = new JsonSerializer<>();
		
		AccountRepository accountRepository =new AccountRepositoryImpl();
		accountRepository.populateData();
		List<BankAccount> accounts = accountRepository.searchAccounts(bankAccount -> bankAccount.getStatus().equals(AccountStatus.ACTIVATED)&&bankAccount.getBalance()>1000);
		
		
		accounts.stream().map(bankAccountJsonSerializer::toJson)
		.forEach(System.out::println);
		
		/*
		 * System.out.println("============="); BankAccount accountById=
		 * accountRepository.findById(33L).orElse(null); if (accountById !=null) {
		 * System.out.println(bankAccountJsonSerializer.toJson(accountById)); }
		 */
		
		
	}

}
