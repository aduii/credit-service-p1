package com.nttdata.p1.credit_service.controller;

import com.nttdata.p1.credit_service.model.Credit;
import com.nttdata.p1.credit_service.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("api/v1/credit")
public class CreditController {
    @Autowired
    private CreditService creditService;

    @PostMapping
    public Mono<Credit> createCredit(@RequestBody Credit credit){
        return creditService.createCredit(credit);
    }

    @GetMapping
    public Flux<Credit> getAllCredits(){
        return creditService.getAllCredits();
    }

    @GetMapping("/{id}")
    public Mono<Credit> findByCreditId(@PathVariable String id){
        return creditService.findByCreditId(id);
    }

    @PutMapping("/{id}")
    public Mono<Credit> updateCredit(
            @PathVariable String id,
            @RequestBody Credit credit){
        return creditService.updateCredit(id, credit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCredit(@PathVariable String id){
        return creditService.deleteCredit(id);
    }
}
