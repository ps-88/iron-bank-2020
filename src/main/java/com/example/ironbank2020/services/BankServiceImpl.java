package com.example.ironbank2020.services;

import com.example.ironbank2020.dao.BankRepo;
import com.example.ironbank2020.dto.Loan;
import com.example.ironbank2020.exceptions.NotEnoughMoneyException;
import com.example.ironbank2020.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private PredictionService predictionService;

    @Override
    public Bank getBank() {
        return bankRepo.findAll().get(0);
    }

    @Override
    public String loan(Loan loan) {
        Bank bank = bankRepo.findAll().get(0);
        if (bank.getAmount() < loan.getAmount()) {
            throw new NotEnoughMoneyException();
        }
        boolean willSurvive = predictionService.willSurvive(loan.getUserName());
        if (willSurvive) {
            bank.setAmount(bank.getAmount() - loan.getAmount());
            return "accepted money transfer";
        } else {

            return "rejected";
        }


    }
}
