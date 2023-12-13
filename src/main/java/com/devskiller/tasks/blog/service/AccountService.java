package com.devskiller.tasks.blog.service;

import com.devskiller.tasks.blog.model.Account;

public interface AccountService {
	public Account loadAccount(Long accountId);

	public Long createAccount(Account account);
}
