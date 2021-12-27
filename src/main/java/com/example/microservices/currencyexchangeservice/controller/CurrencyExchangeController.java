package com.example.microservices.currencyexchangeservice.controller;

import com.example.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.example.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeRate(@PathVariable String from, @PathVariable String to) {
        log.info("Fetching the exchange rate for: {} to  {}", from, to);
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find the currency exchange rate for '" + from + "' to '" + to + "'.");
        }

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
