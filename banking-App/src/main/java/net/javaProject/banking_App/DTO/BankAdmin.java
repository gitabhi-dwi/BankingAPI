package net.javaProject.banking_App.DTO;

import java.sql.Time;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankAdmin {
	@Id
	private int id;
	private String name;
	private String password;
	private LocalTime LastLogin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LTime getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(Time lastLogin) {
		LastLogin = lastLogin;
	}
	public BankAdmin(int id, String name, String password, Time lastLogin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		LastLogin = LocalTime.now();
	}

}
