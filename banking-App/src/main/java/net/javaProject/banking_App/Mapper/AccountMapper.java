package net.javaProject.banking_App.Mapper;

import net.javaProject.banking_App.DTO.AccountDto;
import net.javaProject.banking_App.Enity_dto.Account;



// we have this class methods to convert Account into AccountDto

public class AccountMapper {

	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getId(), 
				accountDto.getAccount_holder_name(), 
				accountDto.getBalance());
		
		return account;
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),account.getAccountHolderName(),account.getBalance()
				);
		return accountDto;
	}
}
