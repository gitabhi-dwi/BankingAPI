package net.javaProject.banking_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaProject.banking_App.Enity_dto.Account;

// In this interface we have extended another interface named as JPARepository to use its methods

public interface Account_repository extends JpaRepository<Account, Long>{

	
}
