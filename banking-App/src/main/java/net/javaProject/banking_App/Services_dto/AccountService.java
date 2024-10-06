package net.javaProject.banking_App.Services_dto;


import java.util.List;

import net.javaProject.banking_App.DTO.AccountDto;


// This is a interface where we declare our methods(no definition)
public interface AccountService {

	AccountDto creatAccount(AccountDto accountDto);
	AccountDto getAccountById(Long id);
	AccountDto DepositMoney(long id, double amount);
	AccountDto WithdrawAmount(long id,double amount);
	List<AccountDto> getAllusers();
	boolean deleteAccountById(long id);
//	AccountDto DepositMoney(Long id, double amount);
}

