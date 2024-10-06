package net.javaProject.banking_App.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaProject.banking_App.DTO.AccountDto;
import net.javaProject.banking_App.Services_dto.AccountService;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
//	Add account rest api
	@PostMapping("AddNewAccount")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return  new ResponseEntity<>(accountService.creatAccount(accountDto), HttpStatus.CREATED);
	}
	
	
//	Find By Id
	@GetMapping(value = "GetAccountById/{id}")
	public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id){
		return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.FOUND);
	}
	
//	Add amount
	@PutMapping("AddAmountToAccount/{id},{amount}")
	public ResponseEntity<AccountDto> DepositAmountbyId(@PathVariable Long id, double amount){
		
		return new ResponseEntity<AccountDto>(accountService.DepositMoney(id, amount),HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping(value = "deleteAccountById/{id}")
	public ResponseEntity<Boolean> deleteAccountById(@PathVariable long id) {
	    boolean deleted = accountService.deleteAccountById(id);
	    
	    if (deleted) {
	        return new ResponseEntity<>(deleted, HttpStatus.NO_CONTENT); // 204 No Content
	    } else {
	        return new ResponseEntity<>(deleted, HttpStatus.NOT_FOUND); // 404 Not Found
	    }
	}
	
	@PutMapping(value = "WithdrawnAmountByid/{id},{amount}")
	public ResponseEntity<AccountDto> WithdrawAmount(@PathVariable long id, double amount){
		
		return new ResponseEntity<>(accountService.WithdrawAmount(id, amount), HttpStatus.ACCEPTED);
		
		
	}

	
}
