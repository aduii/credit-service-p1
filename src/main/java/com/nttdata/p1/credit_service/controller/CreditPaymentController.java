package com.nttdata.p1.credit_service.controller;

import com.nttdata.p1.credit_service.model.CreditPayment;
import com.nttdata.p1.credit_service.service.CreditPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("api/v1/credit-payment")
public class CreditPaymentController {

    @Autowired
    private CreditPaymentService creditPaymentService;

    @PostMapping
    public Mono<CreditPayment> createCreditPayment(@RequestBody CreditPayment creditPayment){
        return creditPaymentService.createCreditPayment(creditPayment);
    }

    @GetMapping
    public Flux<CreditPayment> getAllCreditPayments(){
        return creditPaymentService.getAllCreditPayments();
    }

    @GetMapping("/{id}")
    public Mono<CreditPayment> findByCreditPaymentId(@PathVariable String id){
        return creditPaymentService.findByCreditPaymentId(id);
    }

    @PutMapping("/{id}")
    public Mono<CreditPayment> updateCreditPayment(
            @PathVariable String id,
            @RequestBody CreditPayment creditPayment){
        return creditPaymentService.updateCreditPayment(id, creditPayment);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCreditPayment(@PathVariable String id){
        return creditPaymentService.deleteCreditPayment(id);
    }
}
