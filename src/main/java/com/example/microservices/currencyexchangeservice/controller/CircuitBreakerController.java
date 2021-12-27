package com.example.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "defaultFallbackResponse")
    @CircuitBreaker(name = "sample-api", fallbackMethod = "defaultFallbackResponse")
    @RateLimiter(name="default")
    @Bulkhead(name= "default")
    public String sampleApi() {
        log.info("Sample Api call received");
        ResponseEntity<String> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return responseEntity.getBody();
    }

    public String defaultFallbackResponse(Exception e) {
        return "default-response";
    }
}
