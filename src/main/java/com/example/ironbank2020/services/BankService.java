package com.example.ironbank2020.services;

import com.example.ironbank2020.dto.Loan;
import com.example.ironbank2020.model.Bank;

public interface BankService {
    Bank getBank();

    String loan(Loan loan);
}
