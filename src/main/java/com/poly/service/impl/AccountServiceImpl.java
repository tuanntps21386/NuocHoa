package com.poly.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.entity.Authority;
import com.poly.entity.Role;
import com.poly.service.AccountService;
import com.poly.service.RoleService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO adao;
	@Autowired
	RoleService roleService;
	
	@Override
	public Account findByUsername(String username) {
		return adao.findByUsername(username);
	}

	
	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}

	@Override
	public Account update(Account account) {
		return adao.save(account); 
	}

	@Override
	public void deleteById(String username) {
		adao.deleteById(username); 	
	}

	public Account create(Account account) {

		    return adao.save(account);
	}

	@Override
	public List<Account> findRequest(String string) {
		return adao.findRequest(string); 
	}


}
