package com.example.demo.builderPattern.model.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.demo.builderPattern.model.AccountStatus;
import com.example.demo.builderPattern.model.AccountType;
import com.example.demo.builderPattern.model.BankAccount;
import com.example.demo.builderPattern.model.Director;

public class AccountRepositoryImpl implements AccountRepository{

	private Map<Long, BankAccount> bankAccountMap =new HashMap<>();
	private  long accountCounter=0;
	
	@Override
	public BankAccount save(BankAccount account) {
		Long accountId=++accountCounter;
		account.setAccountId(accountId);
		bankAccountMap.put(accountId, account);
		return account;
	}

	@Override
	public List<BankAccount> list() {
	
		return bankAccountMap.values().stream().toList();
	}

	@Override
	public Optional<BankAccount> findById(Long id) {
		
		BankAccount account =bankAccountMap.get(id);
		if (account==null) {
			return Optional.empty();
		}
		return Optional.of(account);
	}

	@Override
	public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
		return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
	}

	@Override
	public BankAccount update(BankAccount account) {
		bankAccountMap.put(account.getAccountId(), account);
		return account;
	}

	@Override
	public void delete(Long id) {
		bankAccountMap.remove(id);
		
	}
	
	public void populateData() {
		for (int i = 0; i < 10; i++) {
			BankAccount bankAccount = Director.accountBuilder()
					.currency("DIN")
					.balance(1000+Math.random()*9000)
					.status(Math.random()>0.5?AccountStatus.CREATED:AccountStatus.ACTIVATED)
					.type(Math.random()>0.5?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
					.build();
			save(bankAccount);
				 
		}
	}

}
