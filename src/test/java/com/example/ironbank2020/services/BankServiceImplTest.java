package com.example.ironbank2020.services;

import com.example.ironbank2020.dto.Loan;

import com.ironbank.ironbankstarter.exceptions.NotEnoughMoneyException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceMockConf.class)
public class BankServiceImplTest {

    @Autowired
    private BankService bankService;

    @Test
    public void loanRejectedStarks() {
        String answer = bankService.loan(new Loan("Ned stark", 100));
        Assert.assertTrue(answer.toLowerCase().contains("reject"));
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void exceptionWillBeThrownWhenTryingToLoanMoreMoneyThanWeHave() {
        bankService.loan(new Loan("Lanister", 300));
    }
}