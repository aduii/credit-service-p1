package com.nttdata.p1.credit_service.service;

import com.nttdata.p1.credit_service.model.CreditPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditPaymentService {
    Mono<CreditPayment> createCreditPayment(CreditPayment creditPayment);
    Flux<CreditPayment> getAllCreditPayments();
    Mono<CreditPayment> findByCreditPaymentId(String id);
    Mono<CreditPayment> updateCreditPayment(String id, CreditPayment creditPayment);
    Mono<Void> deleteCreditPayment(String id);
}
