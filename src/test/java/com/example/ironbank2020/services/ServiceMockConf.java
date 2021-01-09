package com.example.ironbank2020.services;

import com.example.ironbank2020.dao.BankRepo;
import com.example.ironbank2020.model.Bank;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@TestConfiguration
@ComponentScan(basePackages = "com.example.ironbank2020.services" )
public class ServiceMockConf {

    @Bean
    public BankRepo bankRepo(){
        BankRepo bankRepo = Mockito.mock(BankRepo.class);
        Mockito.when(bankRepo.findAll()).thenReturn(List.of(Bank.builder().amount(200).build()));
        return bankRepo;
    }
}
