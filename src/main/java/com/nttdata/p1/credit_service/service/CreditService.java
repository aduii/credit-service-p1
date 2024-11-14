package com.nttdata.p1.credit_service.service;

import com.nttdata.p1.credit_service.model.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Mono<Credit> createCredit(Credit credit);
    Flux<Credit> getAllCredits();
    Mono<Credit> findByCreditId(String id);
    Mono<Credit> updateCredit(String id, Credit credit);
    Mono<Void> deleteCredit(String id);
}
