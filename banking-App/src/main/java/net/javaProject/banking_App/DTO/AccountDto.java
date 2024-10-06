package net.javaProject.banking_App.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDto {

	private long id;
	private String account_holder_name;
	private double balance;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountDto(long id, String account_holder_name, double balance) {
		super();
		this.id = id;
		this.account_holder_name = account_holder_name;
		this.balance = balance;
	}
	
}
