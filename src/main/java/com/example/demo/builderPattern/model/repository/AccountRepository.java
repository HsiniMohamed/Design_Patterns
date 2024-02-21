package com.example.demo.builderPattern.model.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.example.demo.builderPattern.model.BankAccount;

public interface AccountRepository {

	BankAccount save(BankAccount account) ;
	List<BankAccount> list();
	Optional<BankAccount> findById(Long id);
	List<BankAccount> searchAccounts(Predicate<BankAccount> predicate);
	BankAccount update(BankAccount account);
	void delete(Long id);
	void populateData();
}
