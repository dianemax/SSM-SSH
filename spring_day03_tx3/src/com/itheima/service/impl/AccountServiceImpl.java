package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao = new AccountDaoImpl();


	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}



	@Override
	public void transfer(String outer, String inner, int money) {
		accountDao.out(outer, money);
		accountDao.in(inner, money);
	}

}
