package net.javaProject.banking_App.Services_dto.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaProject.banking_App.DTO.AccountDto;
import net.javaProject.banking_App.Enity_dto.Account;
import net.javaProject.banking_App.Mapper.AccountMapper;
import net.javaProject.banking_App.Repository.Account_repository;
import net.javaProject.banking_App.Services_dto.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private Account_repository account_repository;

	@Autowired
	public AccountServiceImpl(Account_repository account_repository) {
		super();
		this.account_repository = account_repository;
	}

	@Override
	public AccountDto creatAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount=account_repository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		
		Account account  = 
				account_repository.findById(id)
				.orElseThrow(
						()-> new RuntimeException("Id Does Not Exist Enter a Valid Id")); // Lambda Expression"()->"
		
		AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
		
		return accountDto;
	}

	@Override
	public AccountDto DepositMoney(long id, double amount) {
		
		double balance= 0;
		
		AccountDto accountDto = getAccountById(id);
		
			if(accountDto!=null) {
				if(amount>0) {
					 balance = accountDto.getBalance();
					balance = balance + amount;  
					accountDto.setBalance(balance);
					
				}
				else {
					System.out.println("Invalid transaction amount");
				}
				
			}else {
				System.out.println("Enter valid account details");
			}
		
//			accountDto.setBalance(balance);
			
			creatAccount(accountDto);

		return accountDto;
	}

	

	@Override
	public AccountDto WithdrawAmount(long id, double amount) {
		
double balance= 0;
		
		AccountDto accountDto = getAccountById(id);
		
			if(accountDto!=null) {
				if(amount>0) {
					 balance = accountDto.getBalance();
					balance = balance - amount;  
					accountDto.setBalance(balance);
					
				}
				else {
					System.out.println("Invalid transaction amount");
				}
				
			}else {
				System.out.println("Enter valid account details");
			}
			creatAccount(accountDto);

		return accountDto;

		
		
		
	}

	@Override
	public List<AccountDto> getAllusers() {
		
		return null;
	}

	@Override
	public boolean deleteAccountById(long id) {
		
		
		
		
		AccountDto dto = getAccountById(id);
		if(dto!=null) {
			account_repository.deleteById(id);
			return true;
		}
		else
		return false;
	}

}
