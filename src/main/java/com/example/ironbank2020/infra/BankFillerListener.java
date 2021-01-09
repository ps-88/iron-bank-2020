package com.example.ironbank2020.infra;



import com.example.ironbank2020.dao.BankRepo;
import com.example.ironbank2020.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor

public class BankFillerListener {

    private final BankRepo bankRepo;

    @Transactional
    @EventListener(ContextRefreshedEvent.class)
    public void fillBank(){
        Bank bank = Bank.builder().amount(100).build();
        bankRepo.save(bank);

    }
}
