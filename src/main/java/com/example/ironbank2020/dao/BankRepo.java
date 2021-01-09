package com.example.ironbank2020.dao;

import com.example.ironbank2020.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<Bank,Integer> {
}
